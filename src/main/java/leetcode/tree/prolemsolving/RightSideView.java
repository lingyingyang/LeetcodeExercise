package leetcode.tree.prolemsolving;

import leetcode.tree.TreeNode;
import util.NodeUtil;

import java.util.*;

public class RightSideView {
    public static void main(String[] args) {
        TreeNode root = NodeUtil.instanceLevelOrder();
        RightSideView t = new RightSideView();
        List<Integer> out = t.rightSideView(root);
        System.out.println(out.toString());
    }

    /**
     * DFS
     */
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
        int max_depth = -1;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode currNode = nodeStack.pop();
            int depth = depthStack.pop();

            if (currNode != null) {//没到叶子节点边界
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 如果不存在对应深度的节点我们才插入
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, currNode.val);
                }

                nodeStack.push(currNode.left);
                nodeStack.push(currNode.right);//后插入的right node会被读入rightmostValueAtDepth
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int depth = 0; depth <= max_depth; depth++) {
            ans.add(rightmostValueAtDepth.get(depth));
        }

        return ans;
    }
}
