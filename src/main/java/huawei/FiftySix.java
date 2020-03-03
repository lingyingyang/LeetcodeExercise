package huawei;

import java.util.Scanner;

/**
 * 找出字符串中第一个只出现一次的字符
 */
public class FiftySix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            int n = str.length();
            for (int i = 0; i < n; i++) {

                char ch = str.charAt(i);
                String s = ch + "";
                if ((n - str.replaceAll(s, "").length()) == 1) {
                    System.out.println(str.charAt(i));
                    break;
                }
                if (i == n - 1) System.out.println(-1);
            }
        }
    }
}
