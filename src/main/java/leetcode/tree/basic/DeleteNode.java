package leetcode.tree.basic;

import leetcode.tree.TreeNode;
import util.NodeUtil;

public class DeleteNode {
    public static void main(String[] args) {
        TreeNode root = NodeUtil.instanceLevelOrder();
        TreeNode out = new DeleteNode().deleteNode(root, 2);
        NodeUtil.print(out);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) { // 删除的节点在左子树
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) { // 删除的节点在右子树
            root.right = deleteNode(root.right, key);
        } else /*key == root.val*/ {
            if (root.left == null && root.right == null) { // 叶子节点，直接删除
                root = null;
            } else if (root.right != null) { // 有右子树的时候
                // 找后继节点并替换当前节点，然后删除后继节点
                root.val = successor(root).val;
                root.right = deleteNode(root.right, root.val);
            } else /*if (root.left != null)*/ { // 只有左子树的时候
                // 找前继节点并替换当前节点，然后删除前继节点
                root.val = predecessor(root).val;
                root.left = deleteNode(root.left, root.val);
            }
        }

        return root;
    }

    /**
     * Successor 代表的是中序遍历序列的下一个节点。即比当前节点大的最小节点，简称后继节点。 先取当前节点的右节点，然后一直取该节点的左节点，直到左节点为空，则最后指向的节点为后继节点。
     *
     * @param node
     * @return
     */
    private TreeNode successor(TreeNode node) {
        node = node.right;
        while (node.left != null) node = node.left;
        return node;
    }

    /**
     * Predecessor 代表的是中序遍历序列的前一个节点。即比当前节点小的最大节点，简称前驱节点。 先取当前节点的左节点，然后取该节点的右节点，直到右节点为空，则最后指向的节点为前驱节点。
     *
     * @param node
     * @return
     */
    private TreeNode predecessor(TreeNode node) {
        node = node.left;
        while (node.right != null) node = node.right;
        return node;
    }
}
