package tree;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/path-sum-iii/
 */
public class PathSum {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int count = helper(root, 0, sum, map);
        map.forEach((k, v) -> {
            System.out.println(String.format("%d: %d", k, v));
        });
        return count;
    }

    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> map) {
        if (root == null) return 0;

        currSum += root.val;
        int count = map.getOrDefault(currSum - target, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        if (count == 1) System.out.println(String.format(
                "count -> %d, currSum -> %d, currVal -> %d", count, currSum, root.val));

        count += helper(root.left, currSum, target, map) + helper(root.right, currSum, target, map);
//        map.put(currSum, map.get(currSum) - 1);
        return count;
    }
}
