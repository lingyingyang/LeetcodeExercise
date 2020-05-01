package leetcode.tree.prolemsolving;

import leetcode.tree.TreeNode;
import util.NodeUtil;

import java.util.*;

public class RightSideView {
    public static void main(String[] args) {
        TreeNode root = NodeUtil.instanceLevelOrder();
        NodeUtil.print(root);
        RightSideView t = new RightSideView();
        List<Integer> out = t.rightSideView(root);
        System.out.println(out.toString());
    }

    /**
     * DFS
     */
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
        int maxDepth = -1;

        //利用stack的后入先出，确保只读取右节点
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
            int depth = depthStack.pop();
            if (curr == null) continue;//到叶子节点边界

            // 维护二叉树的最大深度
            maxDepth = Math.max(maxDepth, depth);

            // 如果不存在对应深度的节点我们才插入，确保只读取右节点
            if (!rightmostValueAtDepth.containsKey(depth)) {
                rightmostValueAtDepth.put(depth, curr.val);
            }

            nodeStack.push(curr.left);
            nodeStack.push(curr.right);//后插入的右节点会被读入rightmostValueAtDepth
            depthStack.push(depth + 1);
            depthStack.push(depth + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for (int depth = 0; depth <= maxDepth; depth++) {
            ans.add(rightmostValueAtDepth.get(depth));
        }

        return ans;
    }
}
