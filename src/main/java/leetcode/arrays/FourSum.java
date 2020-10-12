package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> out = new FourSum().fourSum(nums, 0);
        for (List<Integer> record : out) {
            System.out.println(record.toString());
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) return ans;

        Arrays.sort(nums);
        int len = nums.length;
        for (int a = 0; a < len - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue; // 如果与前一位相同，跳过

            int minLoop1 = nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3];
            if (minLoop1 > target) break;

            int maxLoop1 = nums[a] + nums[len - 3] + nums[len - 2] + nums[len - 1];
            if (maxLoop1 < target) continue;

            for (int b = a + 1; b < len - 2; b++) {
                if (b > (a + 1) && nums[b] == nums[b - 1]) continue; // 如果与前一位相同，跳过

                int left = b + 1;
                int right = len - 1;

                int minLoop2 = nums[a] + nums[b] + nums[left] + nums[left + 1];
                if (minLoop2 > target) break;

                int maxLoop2 = nums[a] + nums[b] + nums[right] + nums[right - 1];
                if (maxLoop2 < target) continue;

                // left和right的双指针表演
                while (left < right) {
                    int sum = nums[a] + nums[b] + nums[left] + nums[right];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[a], nums[b], nums[left], nums[right]));
                        left++;
                        right--;
                        // 如果与前一位相同，跳过
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (right > left && nums[right] == nums[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                        // 如果与前一位相同，跳过
                        while (left > b && nums[left] == nums[left - 1]) left++;
                    } else {
                        right--;
                        // 如果与前一位相同，跳过
                        while (right < (len - 1) && nums[right] == nums[right + 1]) right--;
                    }
                }
            }
        }

        return ans;
    }
}
