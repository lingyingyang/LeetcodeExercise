package leetcode.tree.traversal;

import leetcode.tree.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        MinDepth t = new MinDepth();
        int out = t.minDepth(root);
        System.out.println(out);
        int out1 = t.byPostOrderTraversal(root);
        assertEquals(2, out1);
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root.left == null && root.right == null) { //叶子节点
            return 1;
        }

        int depth = Integer.MAX_VALUE;
        if (root.left != null) {
            int left = helper(root.left);
            depth = Math.min(left, depth);
        }
        if (root.right != null) {
            int right = helper(root.right);
            depth = Math.min(right, depth);
        }
        return depth + 1;
    }

    /**
     * 后序遍历 left->right->root
     */
    public int byPostOrderTraversal(TreeNode root) {
        if (root == null) {
            return 0; // return 0 for null node
        }
        int left = byPostOrderTraversal(root.left);
        int right = byPostOrderTraversal(root.right);
        // return depth of the subtree rooted at root
        return Math.min(left, right) + 1;
    }
}
