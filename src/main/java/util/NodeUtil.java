package util;

import leetcode.linkedlist.ListNode;
import leetcode.linkedlist.model.multidual.Node;
import leetcode.tree.TreeNode;
import leetcode.tree.traversal.LevelOrderTraversal;

import java.util.List;

public class NodeUtil {
    public static ListNode createListNode(int[] nums) {
        ListNode curr = new ListNode(-1);
        ListNode dump = curr;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;//idx移到下一位
        }
        return dump.next;
    }

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

    public static String print(Node root) {
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
