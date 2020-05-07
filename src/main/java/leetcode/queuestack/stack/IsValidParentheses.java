package leetcode.queuestack.stack;

import java.util.HashMap;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 有效的括号
 */
public class IsValidParentheses {
    public static void main(String[] args) {
        IsValidParentheses t = new IsValidParentheses();
        boolean out = t.isValid("()[]{}");
        assertTrue(out);
    }

    // Hash table that takes care of the mappings.
    private final HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public IsValidParentheses() {
        this.mappings = new HashMap<>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {
        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (mappings.containsKey(c)) {//如果是闭括号

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {//如果是开括号，放入stack
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}