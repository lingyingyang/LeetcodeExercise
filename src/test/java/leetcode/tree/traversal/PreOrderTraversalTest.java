package leetcode.tree.traversal;

import leetcode.tree.TreeNode;
import org.junit.jupiter.api.Test;
import util.NodeUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PreOrderTraversalTest {
    @Test
    void testRecursion() {
        PreOrderTraversal test = new PreOrderTraversal();
        TreeNode root = NodeUtil.instanceLevelOrder();

        List<Integer> out = test.preOrderTraversalByRecursion(root);
//        List<Integer> out = test.preOrderTraversalByIter(root);
        System.out.println(out.toString());
        assertEquals("[4, 2, 1, 3, 6, 5, 7]", out.toString());
    }

    @Test
    void testIter() {
        PreOrderTraversal t = new PreOrderTraversal();
        TreeNode root = NodeUtil.instanceLevelOrder();
        List<Integer> out = t.preOrderTraversalByIter(root);
        System.out.println(out.toString());
        assertEquals("[4, 2, 1, 3, 6, 5, 7]", out.toString());
    }
}