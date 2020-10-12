package leetcode.binarysearch;

import static org.assertj.core.api.Assertions.assertThat;

public class FindPeakElement {
    public static void main(String[] args) {
        FindPeakElement t = new FindPeakElement();
        assertThat(t.findPeakElement(new int[]{1, 2, 3, 1})).isEqualTo(2);
        assertThat(t.findPeakElement(new int[]{1, 2, 3, 4})).isEqualTo(3);
        assertThat(t.findPeakElement(new int[]{1})).isEqualTo(0);
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        while (left < right) { // 终止条件：left == right
            int mid = left + (right - left) / 2;
            if (nums[mid + 1] > nums[mid]) { // 趋势向上，峰值在右区间[mid+1..right]
                left = mid + 1;
            } else { // 趋势向下，峰值在左区间[left..mid]
                right = mid;
            }
        }
        System.out.printf("left: %d, right: %d\n", left, right);
        return left;
    }
}
