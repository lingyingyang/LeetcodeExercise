package leetcode.tree.traversal;

import leetcode.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

class PreOrderTraversalTest {
    @Test
    void testRecursion() {
        PreOrderTraversal test = new PreOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> out = test.preOrderTraversalByRecursion(root);
//        List<Integer> out = test.preOrderTraversalByIter(root);
        System.out.println(out.toString());
    }
}