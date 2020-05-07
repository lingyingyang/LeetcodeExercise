package leetcode.queuestack.stack;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class EvalRPN {
    public static void main(String[] args) {
        EvalRPN t = new EvalRPN();
        String[] in = {"2", "1", "+", "3", "*"};
        int out = t.evalRPN(in);
        assertThat(out).isEqualTo(9);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    stack.push(stack.pop() + stack.pop());
                    break;
                }
                case "-": {
                    int operand = stack.pop();
                    int operate = stack.pop();
                    stack.push(operate - operand);
                    break;
                }
                case "*": {
                    stack.push(stack.pop() * stack.pop());
                    break;
                }
                case "/": {
                    int operand = stack.pop();
                    int operate = stack.pop();
                    stack.push(operate / operand);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}
