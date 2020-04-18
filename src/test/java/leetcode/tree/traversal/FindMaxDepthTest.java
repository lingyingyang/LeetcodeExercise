package leetcode.tree.traversal;

import leetcode.tree.TreeNode;
import leetcode.tree.prolemsolving.FindMaxDepth;
import org.junit.jupiter.api.Test;
import util.NodeUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMaxDepthTest {

    private final FindMaxDepth test = new FindMaxDepth();

    @Test
    void testPreOrder() {
        TreeNode root = NodeUtil.getInstance();
        assertEquals(3, test.byPreOrderTraversal(root));

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        assertEquals(3, test.byPreOrderTraversal(root1));
    }

    @Test
    void testPostOrder() {
        TreeNode root = NodeUtil.getInstance();
        assertEquals(3, test.byPostOrderTraversal(root));
    }
}