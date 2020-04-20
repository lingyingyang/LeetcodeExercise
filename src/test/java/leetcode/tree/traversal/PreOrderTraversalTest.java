package leetcode.tree.traversal;

import leetcode.tree.TreeNode;
import org.junit.jupiter.api.Test;
import util.NodeUtil;

import java.util.List;

class PreOrderTraversalTest {
    @Test
    void testRecursion() {
        PreOrderTraversal test = new PreOrderTraversal();
        TreeNode root = NodeUtil.instanceLevelOrder();

        List<Integer> out = test.preOrderTraversalByRecursion(root);
//        List<Integer> out = test.preOrderTraversalByIter(root);
        System.out.println(out.toString());
    }
}