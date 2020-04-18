package leetcode.tree.problemsolving;

import leetcode.tree.TreeNode;
import leetcode.tree.prolemsolving.BuildTreeWithPreInOrder;
import org.junit.jupiter.api.Test;
import util.NodeUtil;

class BuildTreeWithPreInOrderTest {
    @Test
    void test() {
        BuildTreeWithPreInOrder test = new BuildTreeWithPreInOrder();
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        TreeNode root = test.buildTree(preOrder, inOrder);
        NodeUtil.print(root);
    }
}