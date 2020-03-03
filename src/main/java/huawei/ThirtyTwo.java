package huawei;

import java.util.Scanner;

/**
 * 字符串运用-密码截取
 */
public class ThirtyTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            System.out.println(longestPalindrome(str).length());
        }
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0) return "";

        int start = 0, end = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = aroundCenter(s, i, i);
            int len2 = aroundCenter(s, i, i + 1);
            len = Math.max(len1, len2);
            if (len - 1 > end - start) {
                if (len1 < len2) {
                    start = (i - len / 2) + 1;
                } else {
                    start = i - len / 2;
                }
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int aroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
