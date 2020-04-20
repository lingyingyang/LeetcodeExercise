package leetcode.tree.prolemsolving;

import leetcode.tree.TreeNode;
import util.NodeUtil;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/solution/er-cha-sou-suo-shu-zhong-di-kxiao-de-yuan-su-by-le/
 * 二叉搜索树中第k小的元素
 */
public class KthSmallest {
    public static void main(String[] args) {
        KthSmallest t = new KthSmallest();
        TreeNode root = NodeUtil.instanceLevelOrder();
        ArrayList<Integer> inorder = t.inorder(root, new ArrayList<>());
        System.out.println(inorder);
        int out = t.byIter(root, 2);
        System.out.println(out);
        int out1 = t.byRecur(root, 2);
        System.out.println(out1);
    }

    public int byIter(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }

    public int byRecur(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<>());
        return nums.get(k - 1);
    }

    private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;

        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }
}
