package leetcode.queuestack.stack;

import java.util.Arrays;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures t = new DailyTemperatures();
        int[] out = t.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(out));
        assertThat(Arrays.toString(out)).isEqualTo("[1, 1, 4, 2, 1, 1, 0, 0]");
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        //一个递增的stack，例如在i时，同时i+1比i大，去重了i+2..n中比i+1小的值
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {//倒序遍历
            //得到离当前i递增的stack，stack保存temperatures的idx
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) stack.pop();
            ans[i] = stack.isEmpty() ? 0/*stack为空，说明后序没有值比i大*/
                    : stack.peek() - i/*得到最近比i大的idx*/;
            stack.push(i);
        }
        return ans;
    }
}
