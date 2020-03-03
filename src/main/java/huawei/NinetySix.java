package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 自守数
 */
public class NinetySix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            //int[] dp = new int[n];
            int count = 1;
            //dp[0] = 1;
            for (int i = 1; i <= n - 1; i++) {
                if (String.valueOf((i) * (i)).endsWith(String.valueOf(i))) {
                    count++;
                }

            }
            System.out.println(count);
        }
    }
}
