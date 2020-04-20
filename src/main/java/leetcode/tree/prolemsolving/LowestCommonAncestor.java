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

    /**
     * 使用了后序遍历
     */
    private boolean recurseTree(TreeNode currNode, TreeNode p, TreeNode q) {
        // If reached the end of a branch, return false.
        if (currNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currNode.left, p, q) ? 1 : 0;
        int right = this.recurseTree(currNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int root = (currNode == p || currNode == q) ? 1 : 0;


        // If any two of the flags left, right or root become True
        if (root + left + right >= 2) {
            ans = currNode;
        }

        // Return true if any one of the three bool values is True.
        return (root + left + right > 0);
    }
}
