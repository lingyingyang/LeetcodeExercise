package leetcode.tree.traversal;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PreOrderTraversal {
    public List<Integer> preOrderTraversalByRecursion(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recursionHelper(ans, root);
        return ans;
    }

    private void recursionHelper(List<Integer> ans, TreeNode root) {
        if (root != null) {
            ans.add(root.val);
            recursionHelper(ans, root.left);
            recursionHelper(ans, root.right);
        }
    }

    public List<Integer> preOrderTraversalByIter(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode currNode = root;
        while (currNode != null || !stack.isEmpty()) {
            if (currNode != null) {
                ans.add(currNode.val);
                stack.push(currNode);
                currNode = currNode.left;
            } else { //currNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                currNode = node.right;
            }
        }
        return ans;
    }
}
