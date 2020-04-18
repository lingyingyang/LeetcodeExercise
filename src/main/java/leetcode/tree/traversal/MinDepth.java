package leetcode.tree.traversal;

import leetcode.tree.TreeNode;

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
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        return helper(root);
    }

    private int helper(TreeNode root) {
        System.out.println("curr: " + root.val);
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
        System.out.println("curr min depth: " + (depth + 1));
        return depth + 1;
    }
}
