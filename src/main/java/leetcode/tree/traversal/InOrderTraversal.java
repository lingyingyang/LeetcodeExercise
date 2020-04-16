package leetcode.tree.traversal;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InOrderTraversal {
    public List<Integer> inOrderTraversalByRecursion(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recursionHelper(ans, root);
        return ans;
    }

    private void recursionHelper(List<Integer> ans, TreeNode root) {
        if (root != null) {
            recursionHelper(ans, root.left);
            ans.add(root.val);
            recursionHelper(ans, root.right);
        }
    }

    public List<Integer> inOrderTraversalByIter(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode currNode = root;
        while (currNode != null || !stack.isEmpty()) {
            if (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            } else { //currNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                ans.add(node.val);
                currNode = node.right;
            }
        }
        return ans;
    }
}
