package leetcode.tree.traversal;

import leetcode.tree.TreeNode;
import org.junit.jupiter.api.Test;
import util.NodeUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InOrderTraversalTest {
    private final InOrderTraversal test = new InOrderTraversal();
    private final TreeNode root = NodeUtil.instanceLevelOrder();

    @Test
    void testRecursion() {
        List<Integer> out = test.inOrderTraversalByRecursion(root);
        System.out.println(out);
        assertEquals("[1, 2, 3, 4, 5, 6, 7]", out.toString());
    }

    @Test
    void testIter() {
        List<Integer> out = test.inOrderTraversalByIter(root);
        assertEquals("[1, 2, 3, 4, 5, 6, 7]", out.toString());
    }
}