package leetcode.tree.traversal;

import leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public TreeNode createTree(int[] nums) {
        TreeNode root = null;
        Queue<TreeNode> queue = new LinkedList<>();
        System.out.println("=========================");
        for (int num : nums) {
            root = insertValue(root, num, queue);
            //for debug print
            for (TreeNode q : queue) {
                if (q == null) {
                    System.out.printf("%s", "null ");
                } else {
                    System.out.print(q.val + " ");
                }
            }
            System.out.println();
        }
        new RemoveNodes().removeLeaf(root, -1);
        return root;
    }

    private TreeNode insertValue(TreeNode root, int value, Queue<TreeNode> q) {
        TreeNode node = new TreeNode(value);

        if (root == null) {//1 初始化root
            root = node;
        } else {
            if (q.peek().left == null) {//2 赋值left node
                q.peek().left = node;
            } else if (q.peek().right == null) {//3 赋值right node，并移除其根节点
                q.poll().right = node;
            }
        }
        q.offer(node);
        return root;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//root放进queue里
        while (!queue.isEmpty()) {
            int levelNum = queue.size();//每层的node数量
//            for (TreeNode q : queue) {
//                System.out.print(q.val + " ");
//            }
//            System.out.println();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();//取queue的head元素
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                subList.add(node.val);
            }
            ans.add(subList);
        }
        return ans;
    }
}
