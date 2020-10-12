package leetcode.tree.prolemsolving;

import leetcode.tree.TreeNode;
import util.NodeUtil;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsSubTree {
    public static void main(String[] args) {
        IsSubTree test = new IsSubTree();
        TreeNode s = NodeUtil.instanceLevelOrder();
        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(1);
        t.right = new TreeNode(3);
        assertTrue(test.isSubtree(s, t));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }

    private boolean traverse(TreeNode s, TreeNode t) {
        return s != null && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }

    /**
     * 比较两棵树是否相等
     *
     * @param t1
     * @param t2
     * @return
     */
    private boolean equals(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true; // t1和t2都到达了叶子节点
        else if (t1 == null || t2 == null) return false; // 其中一方还有子节点

        return t1.val == t2.val && equals(t1.left, t2.left) && equals(t1.right, t2.right);
    }
}
