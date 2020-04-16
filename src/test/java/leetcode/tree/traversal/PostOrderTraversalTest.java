package leetcode.tree.traversal;

import leetcode.tree.TreeNode;
import leetcode.tree.TreeNodeUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostOrderTraversalTest {
    private final PostOrderTraversal test = new PostOrderTraversal();
    private final TreeNode root = TreeNodeUtil.getInstance();

    @Test
    void testRecursion() {
        List<Integer> out = test.byRecursion(root);
        assertEquals("[3, 2, 1]", out.toString());
    }

    @Test
    void testIter() {
        List<Integer> out = test.byIter(root);
        assertEquals("[3, 2, 1]", out.toString());
    }
}