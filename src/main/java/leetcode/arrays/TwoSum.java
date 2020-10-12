package leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int[] out = t.twoSum(nums, 9);
        System.out.println(Arrays.toString(out)); // [0, 1]
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain) && map.get(remain) != i) {
                return new int[]{i, map.get(remain)};
            }
        }
        return null;
    }
}
