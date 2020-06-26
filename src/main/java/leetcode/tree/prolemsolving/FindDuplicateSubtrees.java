package leetcode.tree.prolemsolving;

import leetcode.tree.TreeNode;
import util.NodeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindDuplicateSubtrees {
    public static void main(String[] args) {
        TreeNode root = NodeUtil.instanceLevelOrder();
        NodeUtil.print(root);
        List<TreeNode> out = new FindDuplicateSubtrees().findDuplicateSubtrees(root);
        assertEquals(2, out.size());
        for (TreeNode node : out) {
            System.out.print(node.val + " ");
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        Map<String/*pattern*/, Integer/*count*/> map = new HashMap<>();
        helper(root, map, ans);
        return ans;
    }

    private String helper(TreeNode root, Map<String, Integer> map, List<TreeNode> ans) {
        if (root == null) return "null";

        String pattern = root.val + "[" + helper(root.left, map, ans) + "," + helper(root.right, map, ans) + "]";

        map.put(pattern, map.getOrDefault(pattern, 0) + 1);
        if (map.get(pattern) == 2) {
            ans.add(root);
        }
        return pattern;
    }
}
