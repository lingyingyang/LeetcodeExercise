package leetcode.recurrsion;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        ReverseString t = new ReverseString();
        t.reverseString(s);
        System.out.println(Arrays.toString(s));
        t.reverseStringByRecur(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseStringByRecur(char[] s) {
        if (s.length == 0) return;
        int left = 0, right = s.length - 1;
        helper(s, left, right);
    }

    private void helper(char[] s, int left, int right) {
        if (left >= right) return;

        swap(s, left, right);//自顶向下
        helper(s, left + 1, right - 1);
//        swap(s, left, right);//自底向上
    }

    public void reverseString(char[] s) {
        if (s.length == 0) return;

        int left = 0, right = s.length - 1;
        while (left < right) {
            swap(s, left++, right--);
        }
    }

    private void swap(char[] s, int left, int right) {
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
    }
}
