package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 记票统计
 */
public class NinetyOne {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = bf.readLine()) != null) {
            int n = Integer.parseInt(str);
            String[] name = bf.readLine().split(" ");
            int num = Integer.parseInt(bf.readLine());
            String[] s = bf.readLine().split(" ");
            int[] count = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < num; j++) {
                    if (s[j].equals(name[i])) {
                        count[i]++;
                    }
                }
            }
            int Invalid = num;
            for (int m = 0; m < n; m++) {
                Invalid -= count[m];
                System.out.println(name[m] + " : " + count[m]);
            }
            System.out.println("Invalid : " + Invalid);
        }
    }
}
