package leetcode.tree.traversal;

import javafx.util.Pair;
import leetcode.tree.TreeNode;

import java.util.LinkedList;

public class MaxDepth {
    private int ans;

    /**
     * 先序遍历 root->left->right
     */
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

    /**
     * 后序遍历 left->right->root
     */
    public int byPostOrderTraversal(TreeNode root) {
        if (root == null) {
            return 0; // return 0 for null node
        }
        int left_depth = byPostOrderTraversal(root.left);
        int right_depth = byPostOrderTraversal(root.right);
        // return depth of the subtree rooted at root
        return Math.max(left_depth, right_depth) + 1;
    }

    public int byIter(TreeNode root) {
        if (root == null) return 0;
        LinkedList<Pair<TreeNode, Integer/*depth*/>> stack = new LinkedList<>();
        stack.add(new Pair<>(root, 1));

        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> point = stack.poll();
            root = point.getKey();
            int currDepth = point.getValue();
            if (root != null) {//2个方向
                depth = Math.max(depth, currDepth);
                stack.add(new Pair<>(root.left, currDepth + 1));
                stack.add(new Pair<>(root.right, currDepth + 1));
            }
        }
        return depth;
    }
}
