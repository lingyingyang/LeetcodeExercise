package leetcode.queuestack.stack;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
//        String s = "100[leetcode]";
        String out = new DecodeString().decodeString(s);
        System.out.println(out);
        assertThat(out).isEqualTo("aaabcbc");
    }

    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int digit = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                digit = digit * 10 + (ch - '0');//字符数字变成int类型
            } else if (ch == '[') {//stack保存数量和string，然后重置
                intStack.push(digit);
                strStack.push(ans);
                ans = new StringBuilder();
                digit = 0;
            } else if (ch == ']') {//pop出数量和string
                StringBuilder tmp = ans;
                ans = strStack.pop();
                for (digit = intStack.pop(); digit > 0; --digit) {
                    ans.append(tmp);
                }
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
