package huawei;

import java.util.Scanner;

/**
 * 求int型正整数在内存中存储时1的个数
 */
public class Fifteen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = Integer.toBinaryString(n);
        char[] ch = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (ch[i] == '1') {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
