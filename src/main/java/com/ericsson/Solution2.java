package com.ericsson;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Solution2 {
    public static void main(String[] args) {
        boolean out = new Solution2().solution("aabbb");
        assertTrue(out);
    }

    public boolean solution(String S) {
        // write your code in Java SE 8
        char min = S.charAt(0);
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == min) continue;
            if (c > min) min = c;
            if (c < min) return false;
        }
        return true;
    }
}
