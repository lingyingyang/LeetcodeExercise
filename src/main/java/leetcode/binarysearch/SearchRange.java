package leetcode.binarysearch;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchRange {
    public static void main(String[] args) {
        SearchRange t = new SearchRange();
        assertThat(Arrays.toString(t.searchRange(new int[]{1, 2, 3, 3, 3, 3, 3, 5}, 3))).isEqualTo("[2, 6]");
        assertThat(Arrays.toString(t.searchRange(new int[]{1, 2, 3, 3, 3, 3, 3}, 3))).isEqualTo("[2, 6]");
        assertThat(Arrays.toString(t.searchRange(new int[]{1}, 3))).isEqualTo("[-1, -1]");

        System.out.println((t.helper(new int[]{2, 3, 4}, 1, true)));
    }

    public int[] searchRange2(int[] nums, int target) {
        Search t = new Search();
        int left = t.searchLeftMost(nums, target);
        int right = t.searchRightMost(nums, target);
        return new int[]{left, right};
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums.length == 0) return ans;

        int leftIdx = helper(nums, target, true);
        //判断leftIdx和target在nums里
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return ans;
        }
        int rightIdx = helper(nums, target, false) - 1;
        ans[0] = leftIdx;
        ans[1] = rightIdx;
        return ans;
    }

    /**
     * 首先，为了找到最左边（或者最右边）包含 target 的下标（而不是找到的话就返回 true ），所以算法在我们找到一个 target 后不能马上停止。
     * 我们需要继续搜索，直到 left == right 且它们在某个 target 值处下标相同。
     * <p>
     * isLeftMost指示遇到target==nums[mid]时如何做：
     * 当isLeftMost为true，递归查询左区间，找到第一个target的idx
     * 当isLeftMost为false，递归查询右区间，找到第一个比target大的idx
     *
     * @param nums
     * @param target
     * @param isLeftMost
     * @return
     */
    private int helper(int[] nums, int target, boolean isLeftMost) {
        int left = 0, right = nums.length;
        while (left < right) {//终止条件：left==right
            int mid = left + (right - left) / 2;
//            System.out.printf("left: %d, right: %d, mid: %d\n", left, right, mid);
            if (isLeftMost && target == nums[mid]) {
                right = mid;
            } else if (target < nums[mid]) {//左区间
                right = mid;
            } else {//右区间
                left = mid + 1;
            }
        }
        return left;
    }
}
