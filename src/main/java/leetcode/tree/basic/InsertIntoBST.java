package leetcode.tree.basic;

import leetcode.tree.TreeNode;
import util.NodeUtil;

public class InsertIntoBST {
    public static void main(String[] args) {
        TreeNode root = NodeUtil.createTree(new int[]{4, 2, 6, 1, 3, -1, -1});
        NodeUtil.print(root);
        InsertIntoBST t = new InsertIntoBST();
        NodeUtil.print(t.insertIntoBST(root, 5));
        NodeUtil.print(t.insertIntoBSTByIter(root, 7));
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val) {//去左子树
            root.left = insertIntoBST(root.left, val);
        } else {//去右子树
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public TreeNode insertIntoBSTByIter(TreeNode root, int val) {
        TreeNode curr = root;
        while (curr != null) {
            if (val < curr.val) {//去左子树
                if (curr.left == null) { //找到插入的节点
                    curr.left = new TreeNode(val);
                    return root;
                } else curr = curr.left;
            } else {//去右子树
                if (curr.right == null) {//找到插入的节点
                    curr.right = new TreeNode(val);
                    return root;
                } else curr = curr.right;
            }
        }
        return new TreeNode(val);//当root为null的情况
    }
}
