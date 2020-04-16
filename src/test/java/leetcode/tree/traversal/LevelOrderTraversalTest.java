package leetcode.tree.traversal;

import leetcode.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LevelOrderTraversalTest {
    @Test
    void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LevelOrderTraversal test = new LevelOrderTraversal();
        List<List<Integer>> out = test.levelOrder(root);
        System.out.println(out.toString());
        assertEquals("[[3], [9, 20], [15, 7]]", out.toString());
    }
}