package leetcode.tree.basic;

import leetcode.tree.TreeNode;
import util.NodeUtil;

import java.util.Stack;

public class SearchBST {
    public static void main(String[] args) {
        TreeNode root = NodeUtil.instanceLevelOrder();
        TreeNode out = new SearchBST().searchBST(root, 2);
        NodeUtil.print(out);
    }

    private TreeNode ans;

    public TreeNode searchBST(TreeNode root, int val) {
        inorderHelper(root, val);
        return ans;

//        return inorderIter(root, val);
    }

    private void inorderHelper(TreeNode root, int val) {
        if (root == null) return;

        inorderHelper(root.left, val);
        if (root.val == val) this.ans = root;
        inorderHelper(root.right, val);
    }

    /**
     * 可参考{@link BSTIterator}
     *
     * @param root
     * @param target
     * @return
     */
    private TreeNode inorderIter(TreeNode root, int target) {
        Stack<TreeNode> stack = new Stack<>();
        inorderMostLeft(root, stack);//先把包括root的最左子树放进stack
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top.right != null) {//如果有右子树
                inorderMostLeft(top.right, stack);
            }

            if (top.val == target) {
                return top;
            } else if (top.val > target) {
                return null;
            }
        }
        return null;
    }

    private void inorderMostLeft(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {//把当前节点的左子树找到底
            stack.push(root);
            root = root.left;
        }
    }
}
