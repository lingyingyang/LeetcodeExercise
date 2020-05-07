package leetcode.tree.traversal;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历【what】是先遍历左子树，然后访问根节点，然后遍历右子树
 * 【how】二叉搜索树，可以得到一个递增的有序序列
 */
public class InOrderTraversal {
    public List<Integer> inOrderTraversalByRecur(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfsHelper(ans, root);
        return ans;
    }

    private void dfsHelper(List<Integer> ans, TreeNode root) {
        if (root == null) return;

        dfsHelper(ans, root.left);
        ans.add(root.val);
        dfsHelper(ans, root.right);
    }

    public List<Integer> inOrderTraversalByStack(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode point = root;
        while (point != null || !stack.isEmpty()) {
            if (point != null) {//没到边界，一直遍历左子树知道边界
                stack.push(point);
                point = point.left;
            } else { //point == null && !stack.isEmpty()，到了边界，pop左和中，再到右子树
                TreeNode node = stack.pop();
                ans.add(node.val);
                point = node.right;
            }
//            stack.forEach(item -> {
//                System.out.print(item.val + " ");
//            });
//            System.out.println();
        }
        return ans;
    }
}
