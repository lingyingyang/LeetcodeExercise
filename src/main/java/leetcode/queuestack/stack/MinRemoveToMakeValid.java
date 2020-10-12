package leetcode.queuestack.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 移除无效的括号
 */
public class MinRemoveToMakeValid {
    public static void main(String[] args) {
        MinRemoveToMakeValid t = new MinRemoveToMakeValid();
        String out = t.minRemoveToMakeValid("a)b(c)d");
        System.out.println(out);
        assertEquals("ab(c)d", out);
    }

    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) { // 前面没有对应的（
                    indexesToRemove.add(i);
                } else { // 前面有对应的（，并pop之
                    stack.pop();
                }
            }
        }
        // 把多余的（全部放入indexesToRemove
        while (!stack.isEmpty()) indexesToRemove.add(stack.pop());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
