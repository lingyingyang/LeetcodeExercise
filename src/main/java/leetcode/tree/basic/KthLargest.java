package leetcode.tree.basic;

import static org.assertj.core.api.Assertions.assertThat;

class KthLargest {
    public static void main(String[] args) {
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        assertThat(kthLargest.add(3)).isEqualTo(4);
        assertThat(kthLargest.add(5)).isEqualTo(5); // returns 5
        assertThat(kthLargest.add(10)).isEqualTo(5); // returns 5
        assertThat(kthLargest.add(9)).isEqualTo(8); // returns 8
        assertThat(kthLargest.add(4)).isEqualTo(8); // returns 8
    }

    private class BST {
        private class TreeNode {
            private int val;
            // 结点的count包含自己，所以默认是1
            private int count = 1;
            private TreeNode left;
            private TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        private TreeNode root;

        public void add(int val) {
            root = add(root, val);
        }

        private TreeNode add(TreeNode node, int val) {
            if (node == null) {
                return new TreeNode(val);
            }
            if (node.val > val) {
                node.left = add(node.left, val);
            } else if (node.val < val) {
                node.right = add(node.right, val);
            }
            // 元素重复 不添加进树但是count++
            node.count++;
            return node;
        }

        public TreeNode search(int k) {
            return search(root, k);
        }

        private TreeNode search(TreeNode node, int k) {
            if (node == null) {
                return node;
            }
            int leftNodeCount = node.left != null ? node.left.count : 0;
            int rightNodeCount = node.right != null ? node.right.count : 0;
            int currNodeCount = node.count - leftNodeCount - rightNodeCount;
            if (k > currNodeCount + rightNodeCount) {
                // k > 当前结点数加右子树的结点数，则搜索左子树
                return search(node.left, k - currNodeCount - rightNodeCount);
            } else if (k <= rightNodeCount) {
                // k <= 右子树的结点数，则搜索右子树
                return search(node.right, k);
            } else {
                // k == 当前结点数加右子树的结点数，则找到第k大的结点
                return node;
            }
        }
    }

    private int k;
    private BST bst = new BST();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            bst.add(n);
        }
    }

    public int add(int val) {
        bst.add(val);
        return bst.search(k).val;
    }
}
