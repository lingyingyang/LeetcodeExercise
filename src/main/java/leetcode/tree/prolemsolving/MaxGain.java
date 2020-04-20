package leetcode.tree.prolemsolving;

import leetcode.tree.TreeNode;
import util.NodeUtil;

public class MaxGain {
    public static void main(String[] args) {
        TreeNode root = NodeUtil.instanceLevelOrder();
        MaxGain t = new MaxGain();
        int out = t.maxPathSum(root);
        System.out.println(out);
    }

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    /**
     * 使用了后序遍历
     */
    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        // max sum on the left and right sub-trees of node
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int priceNewPath = node.val + leftGain + rightGain;

        // update max_sum if it's better to start a new path
        maxSum = Math.max(maxSum, priceNewPath);

        // for recursion :
        // 如果回溯到上一层，返回最大的路径
        return node.val + Math.max(leftGain, rightGain);
    }
}
