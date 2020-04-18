package leetcode.tree.prolemsolving;

import leetcode.tree.TreeNode;

public class FindMaxDepth {
    private int ans;

    public int byPreOrderTraversal(TreeNode root) {
        ans = 1;
        preOrderHelper(root, ans);
        return ans;
    }

    private void preOrderHelper(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {// 叶子节点
            ans = Math.max(ans, depth);
        }
        preOrderHelper(root.left, depth + 1);
        preOrderHelper(root.right, depth + 1);
    }

    public int byPostOrderTraversal(TreeNode root) {
        if (root == null) {
            return 0; // return 0 for null node
        }
        int left_depth = byPostOrderTraversal(root.left);
        int right_depth = byPostOrderTraversal(root.right);
        // return depth of the subtree rooted at root
        return Math.max(left_depth, right_depth) + 1;
    }
}
