package leetcode.tree.basic;

import leetcode.tree.TreeNode;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        inorderMostLeft(root);
    }

    private void inorderMostLeft(TreeNode root) {
        while (root != null) { // 把当前节点的左子树找到底
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode top = stack.pop();
        if (top.right != null) { // 当有右子树的时候，添加其左子树直到底部
            inorderMostLeft(top.right);
        }
        // 当有右子树的时候，当前节点也是最小的值
        return top.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
