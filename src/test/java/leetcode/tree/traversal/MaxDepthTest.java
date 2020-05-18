package leetcode.tree.traversal;

import leetcode.tree.TreeNode;
import org.junit.jupiter.api.Test;
import util.NodeUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxDepthTest {

    private final MaxDepth t = new MaxDepth();

    @Test
    void testPreOrder() {
        TreeNode root = NodeUtil.instanceSimple();
        assertEquals(3, t.byPreOrderTraversal(root));

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        assertEquals(3, t.byPreOrderTraversal(root1));
    }

    @Test
    void testPostOrder() {
        TreeNode root = NodeUtil.instanceSimple();
        assertEquals(3, t.byPostOrderTraversal(root));
    }

    @Test
    void testIter() {
        TreeNode root = NodeUtil.instanceLevelOrder();
        assertEquals(3, t.byIter(root));
    }
}