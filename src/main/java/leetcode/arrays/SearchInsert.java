package leetcode.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        //        int[] nums = {1, 3};
        int out = new SearchInsert().searchInsert(nums, 2);
        assertEquals(1, out);
    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;

        int left = 0, right = nums.length - 1;
        if (target > nums[right]) return nums.length;
        if (target < nums[left]) return left;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else { // target < nums[mid]
                right = mid - 1;
            }
        }
        return left;
    }
}
