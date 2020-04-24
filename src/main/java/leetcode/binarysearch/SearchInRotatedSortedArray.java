package leetcode.binarysearch;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int minIdx = findMinIdx(nums); // binary search
        if (target == nums[minIdx]) return minIdx;

        int len = nums.length;
        int start = (target <= nums[len - 1]) ? minIdx : 0;
        int end = (target > nums[len - 1]) ? minIdx : len - 1;

        while (start <= end) { // binary search twice
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    private int findMinIdx(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}
