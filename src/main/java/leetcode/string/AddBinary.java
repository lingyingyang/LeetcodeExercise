package leetcode.string;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddBinary {
    public static void main(String[] args) {
        String a = "1";
        String b = "111";
        String out = new AddBinary().addBinary(a, b);
        assertEquals("1000", out);
    }

    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int aLen = a.length();
        int bLen = b.length();
        int n = Math.max(aLen, bLen), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < aLen ? (a.charAt(aLen - 1 - i) - '0') : 0;
            carry += i < bLen ? (b.charAt(bLen - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }

    public String addBinary_my(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int[] as = new int[aChars.length];
        int[] bs = new int[bChars.length];
        int maxLen = Math.max(aChars.length, bChars.length) + 1;
        for (int i = 0; i < aChars.length; i++) {
            char aChar = aChars[i];
            as[i] = Integer.parseInt(String.valueOf(aChar));
        }
        for (int i = 0; i < bChars.length; i++) {
            char bChar = bChars[i];
            bs[i] = Integer.parseInt(String.valueOf(bChar));
        }
        int[] ans = new int[maxLen];

        int aIdx = as.length - 1;
        int bIdx = bs.length - 1;
        int ansIdx = maxLen - 1;
        int carry = 0;
        while (aIdx >= 0 && bIdx >= 0) {
            int sum = as[aIdx--] + bs[bIdx--] + carry;
            int curr = sum % 2;
            carry = sum / 2;
            ans[ansIdx--] = curr;
        }

        if (aIdx >= 0) {
            for (int i = aIdx; i >= 0; i--) {
                int sum = as[aIdx--] + carry;
                int curr = sum % 2;
                carry = sum / 2;
                ans[ansIdx--] = curr;
            }
        } else if (bIdx >= 0) {
            for (int i = bIdx; i >= 0; i--) {
                int sum = bs[bIdx--] + carry;
                int curr = sum % 2;
                carry = sum / 2;
                ans[ansIdx--] = curr;
            }
        }
        ans[ansIdx] = carry;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            if (i == 0 && ans[i] == 0) continue;
            int number = ans[i];
            sb.append(number);
        }
        return sb.toString();
    }
}
