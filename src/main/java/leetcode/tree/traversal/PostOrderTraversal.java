package leetcode.tree.traversal;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 后序遍历【what】是先遍历左子树，然后遍历右子树，最后访问树的根节点
 * 【how】使用栈来处理表达式会变得更加容易，编程常用
 */
public class PostOrderTraversal {
    public List<Integer> byRecursion(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recursionHelper(ans, root);
        return ans;
    }

    private void recursionHelper(List<Integer> ans, TreeNode root) {
        if (root != null) {
            recursionHelper(ans, root.left);//1 left node
            recursionHelper(ans, root.right);//2 right node
            ans.add(root.val);//3 root node
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
