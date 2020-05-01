package leetcode.tree.prolemsolving;

import leetcode.tree.TreeNode;
import util.NodeUtil;

public class KthLargest {
    public static void main(String[] args) {
        TreeNode root = NodeUtil.instanceLevelOrder();
        NodeUtil.print(root);
        KthLargest t = new KthLargest();
        int out = t.kthLargest(root, 3);
        System.out.println(out);
    }

    private int ans, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    /**
     * 反转中序遍历，变成right->root->left，遍历结果就是递减数组
     *
     * @param root
     */
    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) ans = root.val;//找到目标
        dfs(root.left);
    }
}
