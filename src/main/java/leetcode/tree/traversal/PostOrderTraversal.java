package leetcode.tree.traversal;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public List<Integer> byRecursion(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recursionHelper(ans, root);
        return ans;
    }

    private void recursionHelper(List<Integer> ans, TreeNode root) {
        if (root != null) {
            recursionHelper(ans, root.left);
            recursionHelper(ans, root.right);
            ans.add(root.val);
        }
    }

    /**
     * 前序：根->左->右
     * 后序：左->右->根
     * 那么可以把后序当作：根->右->左，然后再反转一下即可。
     */
    public List<Integer> byIter(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                ans.add(node.val);
                if (node.left != null) stack.push(node.left);
                if (node.right != null) stack.push(node.right);
            }
            //反转
            Collections.reverse(ans);
        }
        return ans;
    }
}
