package leetcode.tree.traversal;

import leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);//root放进queue里
        while (!q.isEmpty()) {
            int levelNum = q.size();//每层的node数量
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = q.poll();//取queue的head元素
                //从左到右插入当前节点的下一层节点
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                level.add(node.val);
            }
            ans.add(level);
        }
        return ans;
    }

    public TreeNode createTree(int[] nums) {
        TreeNode root = null;
        Queue<TreeNode> queue = new LinkedList<>();
//        System.out.println("=========================");
        for (int num : nums) {
            root = insertValue(root, num, queue);
            //for debug print
//            for (TreeNode q : queue) {
//                if (q == null) {
//                    System.out.printf("%s", "null ");
//                } else {
//                    System.out.print(q.val + " ");
//                }
//            }
//            System.out.println();
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
}
