package leetcode.tree.prolemsolving;

import leetcode.tree.TreeNode;
import util.NodeUtil;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        DiameterOfBinaryTree t = new DiameterOfBinaryTree();
        int out = t.diameterOfBinaryTree(NodeUtil.instanceLevelOrder());
        System.out.println(out);
    }

    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0; // 访问到空节点了，返回0
        int left = depth(node.left); // 左儿子为根的子树的深度
        int right = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, left + right + 1); // 计算d_node即left+right+1 并更新ans
        return Math.max(left, right) + 1; // 返回该节点为根的子树的深度
    }
}
