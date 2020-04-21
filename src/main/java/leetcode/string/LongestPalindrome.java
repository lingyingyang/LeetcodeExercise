package leetcode.string;

public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome t = new LongestPalindrome();
        String str = "aaeeeeeeeeadccda";
        String out = t.longestPalindrome(str);
        System.out.println(out);
    }

    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";

        int start = 0, end = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);//中心为一个单独的字符
            int len2 = expandAroundCenter(s, i, i + 1);//中心为2个相同的字符
            len = Math.max(len1, len2);
            //len - 1：当前回文的长度；
            //end - start: 之前最长的子回文；
            if (len - 1 > end - start) {//如果大于之前最长的子回文，更新之
                if (len1 < len2) {
                    start = (i - len / 2) + 1;
                } else {
                    start = i - len / 2;
                }
                end = i + len / 2;
                System.out.println("idx:" + i + " len:" + len + " start:" + start + " end:" + end);
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
