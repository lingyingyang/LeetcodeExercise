package leetcode.tree.traversal;

import leetcode.tree.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InOrderTraversalTest {
    private final InOrderTraversal test = new InOrderTraversal();
    private TreeNode root;

    @BeforeEach
    void setUp() {
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
    }

    @Test
    void testRecursion() {
        List<Integer> out = test.inOrderTraversalByRecursion(root);
        assertEquals("[1, 3, 2]", out.toString());
    }

    @Test
    void testIter() {
        List<Integer> out = test.inOrderTraversalByIter(root);
        assertEquals("[1, 3, 2]", out.toString());
    }
}