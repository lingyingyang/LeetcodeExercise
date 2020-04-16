package leetcode.tree.traversal.prolemsolving;

import leetcode.tree.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        int remain = sum - root.val;
        if (root.left == null && root.right == null) { //叶子节点
            return remain == 0;
        }
        //递归调用函数，分别判断根结点的左节点和右节点
        return hasPathSum(root.left, remain) || hasPathSum(root.right, remain);
    }
}
