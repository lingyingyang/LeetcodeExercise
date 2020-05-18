package leetcode.tree.avl;

import leetcode.tree.TreeNode;
import util.NodeUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class IsBalanced {
    public static void main(String[] args) {
        TreeNode root = NodeUtil.instanceLevelOrder();
        root.deletes(new int[]{5, 6});
        boolean out = new IsBalanced().isBalanced(root);
        assertThat(out).isTrue();
    }

    public boolean isBalanced(TreeNode root) {
        return dfsHelper(root).isBalanced();
    }

    private TreeInfo dfsHelper(TreeNode root) {
        if (root == null) return new TreeInfo(true, -1);

        TreeInfo left = dfsHelper(root.left);
        TreeInfo right = dfsHelper(root.right);
        if (!left.isBalanced() || !right.isBalanced()) {
            return new TreeInfo(false, -1);
        }

        //子树是平衡树
        if (Math.abs(left.getHeight() - right.getHeight()) < 2) {
            return new TreeInfo(true, Math.max(left.getHeight(), right.getHeight()) + 1);
        }

        //子树不是平衡树
        return new TreeInfo(false, -1);
    }

    static class TreeInfo {
        private boolean balanced;
        private int height;

        public TreeInfo(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }

        public boolean isBalanced() {
            return balanced;
        }

        public void setBalanced(boolean balanced) {
            this.balanced = balanced;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
