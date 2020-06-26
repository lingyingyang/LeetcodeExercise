package leetcode.dp;

import leetcode.tree.TreeNode;
import util.NodeUtil;

import static java.lang.Integer.max;
import static org.assertj.core.api.Assertions.assertThat;

public class HouseRobberIII {
    public static void main(String[] args) {
        TreeNode root = NodeUtil.createTree(new int[]{3, 2, 3, -1, 3, -1, 1});
        int out = new HouseRobberIII().rob(root);
        assertThat(out).isEqualTo(7);
    }

    //0: 不偷；1：偷
    public static final int NO_ROB = 0;
    public static final int ROB = 1;

    public int rob(TreeNode root) {
        int[] out = robHelper(root);
        return max(out[NO_ROB], out[ROB]);
    }

    public int[] robHelper(TreeNode root) {
        if (root == null) return new int[2];

        int[] ans = new int[2];

        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);

        //不偷的时候，当前节点的最大值 = 左节点能偷到的最大值 + 右节点能偷到的最大值
        ans[NO_ROB] = max(left[ROB], left[NO_ROB]) + max(right[ROB], right[NO_ROB]);
        //偷的时候，当前节点的最大值 = 左节点不偷时的最大值 + 右节点不偷时的最大值 + 当前节点的值
        ans[ROB] = left[NO_ROB] + right[NO_ROB] + root.val;
        return ans;
    }
}
