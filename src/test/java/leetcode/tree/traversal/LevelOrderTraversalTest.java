package leetcode.tree.traversal;

import leetcode.tree.TreeNode;
import org.junit.jupiter.api.Test;
import util.NodeUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LevelOrderTraversalTest {
    @Test
    void test() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }

    @Test
    void createTree() {
        LevelOrderTraversal t = new LevelOrderTraversal();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] nums1 = {1, 2, 3, -1, -1, 6, 7};
        int[] nums2 = {1, 2, 3, 4, -1, 6, 7};
        int[] nums3 = {1, 2, 3, -1, 5, 6, 7};
        TreeNode root = t.createTree(nums);
        NodeUtil.print(root);
        TreeNode root1 = t.createTree(nums1);
        NodeUtil.print(root1);
        TreeNode root2 = t.createTree(nums2);
        NodeUtil.print(root2);
        TreeNode root3 = t.createTree(nums3);
        NodeUtil.print(root3);
    }

    @Test
    void levelOrder() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        LevelOrderTraversal test = new LevelOrderTraversal();
        List<List<Integer>> out = test.levelOrder(root);
        System.out.println(out.toString());
        assertEquals("[[1], [2, 3], [4, 5, 6, 7]]", out.toString());
    }
}