package leetcode.tree.problemsolving;

import leetcode.tree.TreeNode;
import leetcode.tree.prolemsolving.BuildTreeWithInPostOrder;
import org.junit.jupiter.api.Test;
import util.NodeUtil;

class BuildTreeWithInPostOrderTest {
    @Test
    void test() {
        BuildTreeWithInPostOrder test = new BuildTreeWithInPostOrder();
        int[] inOrder = {9, 3, 15, 20, 7};
        int[] postOrder = {9, 15, 7, 20, 3};
        TreeNode root = test.buildTree(inOrder, postOrder);
        NodeUtil.print(root);
    }
}