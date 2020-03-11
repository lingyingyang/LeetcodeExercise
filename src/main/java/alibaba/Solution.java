package alibaba;

import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 代码测评题目：
 * <p>
 * 用户有多种支付方式:paymentType（余额、红包、优惠券，代金券等），假如每种支付方式需要通过同步调用远程服务获取可用性。
 * 在外部资源环境不变情况下，请设计程序以最短响应时间获得尽可能多的可用支付方式列表。
 * <p>
 * 测评时间要求：1个小时，可提前交卷
 * 测评其它说明：无需编译通过，尽量少的伪代码
 */
@Slf4j
public class Solution {
    // 采用了默认的AbortPolicy丢弃策略，抛出异常并丢弃，没有catch
    public static final String REMOTE_URL = "localhost";

    //获取所有可用的渠道（需要调用PaymentRemoteService，判断渠道是否可用）
    public List<Object> getAvailablePayments(List<String> paymentTypes) throws InterruptedException {
        PaymentRemoteService service = new PaymentRemoteService();
        Map<String, Object> map = new ConcurrentHashMap<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                4, 4, 1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                new ThreadPoolExecutor.DiscardPolicy());

        List<Callable<String>> tasks = new ArrayList<>();
        for (String paymentType : paymentTypes) {
            tasks.add(() -> {
                ConsultResult res = service.isEnabled(paymentType);
                if (res.getIsEnable()) {
                    map.put(paymentType, res);
                } else {
                    log.error("getAvailablePayments() has error in paymentType: {}, error: {}",
                            paymentType, res.getErrorCode());
                }
                return "";
            });
        }
        List<Future<String>> futures = executor.invokeAll(
                tasks, 2, TimeUnit.SECONDS);
        executor.shutdown();
        for (Future<String> future : futures) {
            log.info("{} isCancelled => {}", future.toString(), future.isCancelled());
        }
        return new ArrayList<>(map.values());
    }

    //同步调用远程服务，判断渠道是否可用（远程服务的信息自行设计）
    public static class PaymentRemoteService {
        public ConsultResult isEnabled(String paymentType) {
            ConsultResult ans = null;
            try {
                LocalInterface localObject = (LocalInterface) Naming
                        .lookup("rmi://" + REMOTE_URL + "/remote.LocalInterface");
                ans = localObject.isEnable(paymentType);
            } catch (RemoteException | NotBoundException | MalformedURLException e) {
                log.error("PaymentRemoteService.isEnabled() has error");
            }
            return ans;
        }
    }

    public interface LocalInterface {
        ConsultResult isEnable(String paymentType);
    }


    //渠道可用性类，直接使用即可。
    public static class ConsultResult {

        public ConsultResult(boolean isEnable, String errorCode) {
            this.isEnable = isEnable;
            this.errorCode = errorCode;
        }

        /**
         * 咨询结果是否可用
         */
        private boolean isEnable;

        /**
         * 错误码
         */
        private String errorCode;

        public boolean getIsEnable() {
            return isEnable;
        }

        public String getErrorCode() {
            return errorCode;
        }

    }
}
