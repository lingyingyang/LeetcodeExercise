package leetcode.tree.prolemsolving;

import leetcode.tree.TreeNode;

public class BuildTreeWithInPostOrder {
    private int IdxInOrder; // index of inorder array
    private int IdxPostOrder; // index of postorder array

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        IdxInOrder = inorder.length - 1;
        IdxPostOrder = postorder.length - 1;

        return buildTree(inorder, postorder, null);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode end) {
        if (IdxPostOrder < 0) {
            return null;
        }

        // 后序数组的最后一位就是root
        TreeNode currNode = new TreeNode(postorder[IdxPostOrder--]);

        // if right node exist, create right subtree
        if (inorder[IdxInOrder] != currNode.val) {
            currNode.right = buildTree(inorder, postorder, currNode);
        }
        IdxInOrder--;

        // if left node exist, create left subtree
        if ((end == null) || (inorder[IdxInOrder] != end.val)) {
            currNode.left = buildTree(inorder, postorder, end);
        }
        return currNode;
    }
}
