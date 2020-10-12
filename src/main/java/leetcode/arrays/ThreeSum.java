package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/ 三数之和等于0
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum t = new ThreeSum();
        List<List<Integer>> out = t.threeSum(nums);
        System.out.println(out.toString());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // 排序
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (nums[i] > 0) return ans; // 假如第一位>0，因为已经排序好，所以后面不可能有三个数加和等于0，直接返回结果
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重

            int curr = nums[i];
            int left = i + 1, right = len - 1;
            while (left < right) { // 双指针
                int tmp = curr + nums[left] + nums[right];
                if (tmp == 0) {
                    List<Integer> item = new ArrayList<>();
                    item.add(curr);
                    item.add(nums[left]);
                    item.add(nums[right]);
                    ans.add(item);
                    // 执行循环，判断左界和右界是否和下一位置重复，去除重复解。
                    // 并同时将 left, right 移到下一位置，寻找新的解
                    while (left < right && nums[left + 1] == nums[left]) ++left;
                    while (left < right && nums[right - 1] == nums[right]) --right;
                    ++left;
                    --right;
                } else if (tmp < 0) {
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return ans;
    }
}
