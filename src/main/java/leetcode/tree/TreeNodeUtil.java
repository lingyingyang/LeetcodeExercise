package leetcode.tree;

public class TreeNodeUtil {
    public static TreeNode getInstance() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }
}
