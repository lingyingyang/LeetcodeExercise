package com.ericsson;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
class Solution {
    public static void main(String[] args) {
        int out = new Solution().solution(-999);
        System.out.println(out);
    }

    public int solution(int N) {
        // write your code in Java SE 8
        String number = String.valueOf(N);
        char[] out = new char[number.length() + 1];
        int idx = 0;
        int i = 0;
        boolean isNegative = false;
        boolean inserted = false;
        if (number.charAt(i) == '-') {
            out[idx++] = '-';
            i++;
            isNegative = true;
        }
        for (; i < number.length(); i++) {
            char c = number.charAt(i);
            if (!inserted) {
                if (isNegative && '5' < c) {
                    out[idx++] = '5';
                    inserted = true;
                } else if ('5' > c) {
                    out[idx++] = '5';
                    inserted = true;
                }
            }
            out[idx++] = c;
        }
        if (idx != out.length) out[out.length - 1] = '5';
        return Integer.parseInt(String.valueOf(out));
    }
}
