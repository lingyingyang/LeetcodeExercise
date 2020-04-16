package leetcode.tree.traversal.prolemsolving;

import leetcode.tree.TreeLinkNode;

public class PopulateNextNode {
    public TreeLinkNode connect(TreeLinkNode root) {
        TreeLinkNode level = root;
        while (level != null) {
            TreeLinkNode cur = level;
            while (cur != null) {
                if (cur.left != null) cur.left.next = cur.right;
                if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;

                cur = cur.next;
            }
            level = level.left;
        }
        return root;
    }

    public TreeLinkNode connectImperfectTree(TreeLinkNode root) {
        TreeLinkNode start = root;
        while (root != null) {
            TreeLinkNode tempChild = new TreeLinkNode(0);
            TreeLinkNode currentChild = tempChild;
            while (root != null) {
                if (root.left != null) {
                    currentChild.next = root.left;
                    currentChild = currentChild.next;
                }
                if (root.right != null) {
                    currentChild.next = root.right;
                    currentChild = currentChild.next;
                }
                root = root.next;
            }
            root = tempChild.next;
        }
        return start;
    }
}
