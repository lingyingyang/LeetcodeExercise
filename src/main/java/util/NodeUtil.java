package util;

import leetcode.tree.ListNode;
import leetcode.tree.TreeNode;
import leetcode.tree.traversal.LevelOrderTraversal;

import java.util.List;

public class NodeUtil {
    public static TreeNode createTree(int[] nums) {
        LevelOrderTraversal t = new LevelOrderTraversal();
        return t.createTree(nums);
    }

    public static TreeNode instanceSimple() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }

    public static TreeNode instanceLevelOrder() {
        int[] nums = {4, 2, 6, 1, 3, 5, 7};
        TreeNode root = NodeUtil.createTree(nums);
        print(root);
        return root;
    }

    public static String print(ListNode root) {
        StringBuffer out = new StringBuffer();
        while (root != null) {
            out.append(String.format("%d -> ", root.val));
            root = root.next;
        }
        System.out.println(out.toString());
        return out.toString();
    }

    public static void print(TreeNode root) {
        LevelOrderTraversal traversal = new LevelOrderTraversal();
        List<List<Integer>> out = traversal.levelOrder(root);
        for (List<Integer> level : out) {
            System.out.println(level.toString());
        }
    }
}
