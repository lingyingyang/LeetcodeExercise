package leetcode.tree;

import leetcode.tree.prolemsolving.PathSum;
import org.junit.jupiter.api.Test;

class PathSumTest {
    @Test
    void whenResult_thenOk() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        PathSum test = new PathSum();
        int result = test.pathSum(root, 8);
        System.out.println(result);
    }
}