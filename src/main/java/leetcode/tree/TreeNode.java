package leetcode.tree;

import leetcode.tree.basic.DeleteNode;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        val = value;
    }

    public void delete(int val) {
        new DeleteNode().deleteNode(this, val);
    }

    public void deletes(int[] list) {
        DeleteNode t = new DeleteNode();
        for (int val : list) {
            t.deleteNode(this, val);
        }
    }
}
