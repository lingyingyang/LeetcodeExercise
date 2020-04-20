package leetcode.tree.prolemsolving;

import leetcode.tree.TreeNode;
import util.NodeUtil;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        TreeNode root = NodeUtil.createTree(nums);
        LowestCommonAncestor t = new LowestCommonAncestor();
        TreeNode out = t.lowestCommonAncestor(root,
                new TreeNode(9), new TreeNode(11));
        System.out.println(out.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        recurseTree(root, p, q);
        return ans;
    }

    // Variable to store LCA node.
    private TreeNode ans = null;

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }
}
