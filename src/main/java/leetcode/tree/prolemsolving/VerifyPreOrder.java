package leetcode.tree.prolemsolving;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/verify-preorder-sequence-in-binary-search-tree/solution/java-liang-chong-jie-fa-by-npe_tle/
 */
public class VerifyPreOrder {
    // 用单调栈的方式，递减栈，当碰到一个数比栈顶元素大的时候，说明从左子树到了右子树。
    // 此时要删掉左子树的所有节点，并且保留子树的根为最小值，此时遍历的所有右子树的节点都必须大于这个根，否则非法
    public boolean verifyPreorder(int[] in) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;

        for (int value : in) {
            if (value < min) {
                return false;
            }

            while (!stack.isEmpty() && value > stack.peek()) {
                min = stack.pop();
            }
            stack.push(value);
        }

        return true;
    }
}
