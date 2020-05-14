package leetcode.binarysearch;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        SearchInRotatedSortedArray test = new SearchInRotatedSortedArray();
        int[] in = new int[]{4, 5, 6, 7, 0, 1, 2};
//        assertThat(test.search(in, 1)).isEqualTo(5);
        assertThat(test.search(in, 4)).isEqualTo(0);
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int minIdx = findMinIdx(nums);

        int len = nums.length;
        int start, end;
        //拆分成[0..minIdx-1],[minIdx..len-1]
        if (target <= nums[len - 1]) {
            start = minIdx;
            end = len - 1;
        } else {
            start = 0;
            end = minIdx - 1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {//右区间
                start = mid + 1;
            } else {//左区间
                end = mid - 1;
            }
        }

        return -1;
    }

    private int findMinIdx(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //必须先找右区间，因为是旋转排序数组
            //如果min在右边，mid值肯定比right大
            //如果min在左边，mid值肯定比right小
            if (nums[right] < nums[mid]) {
                //在右区间，不包括mid
                left = mid + 1;
            } else {//在左区间，包括mid
                right = mid;
            }
        }
        return left;
    }
}
