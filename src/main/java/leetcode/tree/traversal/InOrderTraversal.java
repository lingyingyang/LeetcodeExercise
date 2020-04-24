package leetcode.tree.traversal;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 中序遍历【what】是先遍历左子树，然后访问根节点，然后遍历右子树
 * 【how】二叉搜索树，可以得到一个递增的有序序列
 */
public class InOrderTraversal {
    public List<Integer> inOrderTraversalByRecursion(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(ans, root);
        return ans;
    }

    private void helper(List<Integer> ans, TreeNode root) {
        if (root != null) {
            helper(ans, root.left);
            ans.add(root.val);
            helper(ans, root.right);
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
            stack.forEach(item -> {
                System.out.print(item.val + " ");
            });
            System.out.println();
        }
        return ans;
    }
}
