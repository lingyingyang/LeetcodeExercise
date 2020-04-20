package leetcode.tree.traversal;

import leetcode.tree.TreeNode;
import util.NodeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/solution/er-cha-shu-de-ju-chi-xing-ceng-ci-bian-li-by-leetc/
 */
public class ZigzagLevelOrder {
    public static void main(String[] args) {
        ZigzagLevelOrder t = new ZigzagLevelOrder();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = NodeUtil.createTree(nums);
        List<List<Integer>> out = t.BFS(root);
        System.out.println(out.toString());
        List<List<Integer>> out1 = t.DFS(root);
        System.out.println(out1.toString());
    }

    public List<List<Integer>> BFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();

        //使用双向链表
        // add the root element with a delimiter to kick off the BFS loop
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        q.addLast(null);

        LinkedList<Integer> level = new LinkedList<>();
        boolean isLeftOrder = true;

        while (q.size() > 0) {
            TreeNode currNode = q.pollFirst();
            if (currNode != null) {//null delimiter表示下一层
                //left order的时候，FIFO，从左到右的方式读取值；
                //right order的时候，FILO，从右到左的方式读取值；
                if (isLeftOrder)
                    level.addLast(currNode.val);
                else
                    level.addFirst(currNode.val);

                if (currNode.left != null)
                    q.addLast(currNode.left);
                if (currNode.right != null)
                    q.addLast(currNode.right);
            } else {
                // finish the scan of one level
                ans.add(level);
                level = new LinkedList<>();
                // prepare for the next level
                if (q.size() > 0)
                    q.addLast(null);
                isLeftOrder = !isLeftOrder;
            }
        }
        return ans;
    }

    public List<List<Integer>> DFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }

    private void helper(TreeNode node, int level, List<List<Integer>> ans) {
        if (level >= ans.size()) {
            //1.1 如果是第一次访问该层的节点，即该层的双端队列不存在。那么创建一个双端队列，并添加该节点到队列中。
            LinkedList<Integer> newLevel = new LinkedList<>();
            newLevel.add(node.val);
            ans.add(newLevel);
        } else {
            //1.2 如果当前层的双端队列已存在，根据顺序，将当前节点插入队列头部或尾部
            if (level % 2 == 0)
                ans.get(level).add(node.val);
            else
                ans.get(level).add(0, node.val);
        }

        //2 为每个节点调用递归方法
        if (node.left != null) helper(node.left, level + 1, ans);
        if (node.right != null) helper(node.right, level + 1, ans);
    }
}
