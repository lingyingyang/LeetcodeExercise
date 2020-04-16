package leetcode.tree.traversal;

import leetcode.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

class PreOrderTraversalTest {
    @Test
    void testRecursion() {
        PreOrderTraversal test = new PreOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> out = test.preOrderTraversalByRecursion(root);
//        List<Integer> out = test.preOrderTraversalByIter(root);
        System.out.println(out.toString());
    }
}