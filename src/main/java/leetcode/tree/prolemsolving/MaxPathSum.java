package leetcode.tree.prolemsolving;

import leetcode.tree.TreeNode;
import util.NodeUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxPathSum {
    public static void main(String[] args) {
        TreeNode root = NodeUtil.instanceLevelOrder();
        NodeUtil.print(root);
        MaxPathSum t = new MaxPathSum();
        int out = t.maxPathSum(root);
        assertEquals(22, out);
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

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int priceNewPath = node.val + leftGain + rightGain;

        // update max_sum if it's better to start a new path
        maxSum = Math.max(maxSum, priceNewPath);

        // 如果回溯到上一层，返回最大的路径
        return node.val + Math.max(leftGain, rightGain);
    }
}
