package leetcode.tree.prolemsolving;

import leetcode.tree.TreeNode;
import util.NodeUtil;

public class ConvertArrayToTree {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = new ConvertArrayToTree().sortedArrayToBST(nums);
        NodeUtil.print(root);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;

        // always choose left middle node as a root
        int mid = (left + right) / 2;

        // 中序遍历: left -> node -> right
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
}
