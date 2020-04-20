package leetcode.tree.traversal;

import leetcode.tree.TreeNode;
import util.NodeUtil;

public class RemoveNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        RemoveNodes t = new RemoveNodes();
        TreeNode out = t.removeLeaf(root, 4);
        NodeUtil.print(out);
    }

    public TreeNode removeLeaf(TreeNode root, int target) {
        if (root == null) return null;

        root.left = removeLeaf(root.left, target);
        root.right = removeLeaf(root.right, target);

        if (root.left == null && root.right == null) {//叶子节点
            if (root.val == target) return null;//删除该叶子节点
        }
        return root;
    }
}
