package leetcode.tree.basic;

import leetcode.tree.TreeNode;

public class VerifyTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        VerifyTree t = new VerifyTree();
        System.out.println(t.isValidBST(root));//true
    }

    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;//不得小于下界
        if (upper != null && val >= upper) return false;//不得大于上届

//        if (!helper(node.left, lower, val)) return false;
//        if (!helper(node.right, val, upper)) return false;
//        return true;
        return helper(node.left, lower, val) && helper(node.right, val, upper);
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
}
