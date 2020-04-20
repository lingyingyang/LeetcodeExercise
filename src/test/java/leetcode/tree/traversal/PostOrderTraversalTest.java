package leetcode.tree.traversal;

import leetcode.tree.TreeNode;
import org.junit.jupiter.api.Test;
import util.NodeUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostOrderTraversalTest {
    private final PostOrderTraversal test = new PostOrderTraversal();
    private final TreeNode root = NodeUtil.instanceLevelOrder();

    @Test
    void testRecursion() {
        List<Integer> out = test.byRecursion(root);
        System.out.println(out);
//        assertEquals("[3, 2, 1]", out.toString());
    }

    @Test
    void testIter() {
        List<Integer> out = test.byIter(root);
        assertEquals("[3, 2, 1]", out.toString());
    }
}