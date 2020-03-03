package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 购物单
 */
public class Sixteen {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int totalMoney = Integer.parseInt(str.split(" ")[0]) / 10;
        int itemNum = Integer.parseInt(str.split(" ")[1]);
        int[] v = new int[itemNum + 1];
        int[] p = new int[itemNum + 1];
        int[] q = new int[itemNum + 1];
        int[][] ans = new int[itemNum + 1][totalMoney + 1];
        for (int i = 1; i <= itemNum; i++) {
            String[] strings = br.readLine().split(" ");
            v[i] = Integer.parseInt(strings[0]) / 10;
            p[i] = Integer.parseInt(strings[1]) * v[i];
            q[i] = Integer.parseInt(strings[2]);
        }

        for (int i = 1; i <= itemNum; i++) {
            for (int j = 1; j <= totalMoney; j++) {
                if (q[i] == 0) {
                    if (v[i] <= j) {
                        ans[i][j] = Math.max(ans[i - 1][j], ans[i - 1][j - v[i]] + p[i]);
                    }
                } else {
                    if (v[i] + v[q[i]] <= j) {
                        ans[i][j] = Math.max(ans[i - 1][j], ans[i - 1][j - v[i]] + p[i]);
                    }
                }
            }
        }
        System.out.println(ans[itemNum][totalMoney] * 10);
    }
}
