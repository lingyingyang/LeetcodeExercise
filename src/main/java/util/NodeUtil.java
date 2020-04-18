package util;

import leetcode.tree.ListNode;
import leetcode.tree.TreeNode;
import leetcode.tree.traversal.LevelOrderTraversal;

import java.util.List;

public class NodeUtil {
//    public static TreeNode genTree(int[] nums) {
//        int idx = 0;
//
//        TreeNode node = new TreeNode(nums[idx++]);
//        node.left = new TreeNode(nums[idx++]);
//        node.right = new TreeNode(nums[idx++]);
//    }

    public static String print(ListNode root) {
        StringBuffer out = new StringBuffer();
        while (root != null) {
            out.append(String.format("%d -> ", root.val));
            root = root.next;
        }
        return out.toString();
    }

    public static TreeNode getInstance() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }

    public static void print(TreeNode root) {
        LevelOrderTraversal traversal = new LevelOrderTraversal();
        List<List<Integer>> out = traversal.levelOrder(root);
        for (List<Integer> list : out) {
            System.out.println(list.toString());
        }
    }
}
