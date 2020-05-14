package leetcode.binarysearch;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://www.cnblogs.com/luoxn28/p/5767571.html
 */
public class Search {
    public static void main(String[] args) {
        Search t = new Search();
        assertThat(t.searchFirstMatch(new int[]{-1, 0, 3, 5, 9, 12}, 12)).isEqualTo(5);

        //LeftMost
        assertThat(t.searchLeftMost(new int[]{1, 2, 2}, 2)).isEqualTo(1);
        assertThat(t.searchLeftMost(new int[]{2, 2, 2}, 2)).isEqualTo(0);
        assertThat(t.searchLeftMost(new int[]{2, 2, 2}, 3)).isEqualTo(-1);
        assertThat(t.searchLeftMost(new int[]{2, 2, 2}, 1)).isEqualTo(-1);

        assertThat(t.searchLeftMost_exitWhenLeftEqualRight(new int[]{1, 2, 2}, 2)).isEqualTo(1);
        assertThat(t.searchLeftMost_exitWhenLeftEqualRight(new int[]{2, 2, 2}, 2)).isEqualTo(0);
        assertThat(t.searchLeftMost_exitWhenLeftEqualRight(new int[]{2, 2, 2}, 3)).isEqualTo(-1);
        assertThat(t.searchLeftMost_exitWhenLeftEqualRight(new int[]{2, 2, 2}, 1)).isEqualTo(-1);

        //RightMost
        assertThat(t.searchRightMost(new int[]{2, 2, 3}, 2)).isEqualTo(1);
        assertThat(t.searchRightMost(new int[]{2, 2, 2}, 2)).isEqualTo(2);
        assertThat(t.searchRightMost(new int[]{2, 2, 2}, 3)).isEqualTo(-1);
        assertThat(t.searchRightMost(new int[]{2, 2, 2}, 1)).isEqualTo(-1);
        assertThat(t.searchRightMost(new int[]{2, 2, 3, 4}, 2)).isEqualTo(1);

//        assertThat(t.searchRightMost_existWhenLeftEqualsRight(new int[]{2, 2, 3}, 2)).isEqualTo(1);
//        assertThat(t.searchRightMost_existWhenLeftEqualsRight(new int[]{2, 2, 2}, 2ff)).isEqualTo(2);
//        assertThat(t.searchRightMost_existWhenLeftEqualsRight(new int[]{2, 2, 2}, 3)).isEqualTo(-1);
//        assertThat(t.searchRightMost_existWhenLeftEqualsRight(new int[]{2, 2, 2}, 1)).isEqualTo(-1);
    }

    /**
     * 找到遇到的第一个等于target的idx，否则返回-1。
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchFirstMatch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {//终止条件：left==right
            int mid = left + (right - left) / 2;//分成[0..mid-1],mid,[mid+1..len-1]来比较
            if (target == nums[mid]) return mid;
            else if (target < nums[mid]) {//target在左边的区间
                right = mid - 1;
            } else {//target在右边的区间
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 其实就是left和right组成的窗口一直在缩小一半，直到right在left的前一位或者left在right的后一位，即[right,left]
     * 返回最左边等于target的idx，否则返回-1
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchLeftMost(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {//终止条件：left刚好大于right，且right在left前一位
            int mid = left + (right - left) / 2;//分成[0..mid-1],mid,[mid+1..len-1]来比较
            if (target <= nums[mid]) {//target在左区间，等于的条件划给了左区间
                right = mid - 1;
            } else {//target在右区间
                left = mid + 1;
            }
        }
        System.out.printf("left: %d, right: %d\n", left, right);
        if (left < nums.length && nums[left] == target) return left;
        else return -1;
    }

    public int searchLeftMost_exitWhenLeftEqualRight(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {//终止条件：left==right
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {//target在左区间，等于的条件划给了左区间
                right = mid;
            } else /*target > nums[mid]*/ {//target在右区间
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    /**
     * 其实就是left和right组成的窗口一直在缩小一半，直到right在left的前一位或者left在right的后一位，即[right,left]
     * 返回最右边等于target的idx，否则返回-1
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchRightMost(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {//终止条件：left刚好大于right，且right在left前一位
            int mid = left + (right - left) / 2;//分成[0..mid-1],mid,[mid+1..len-1]来比较
            if (target < nums[mid]) {//target在左区间
                right = mid - 1;
            } else /*target >= nums[mid]*/ {//target在右区间，等于的条件划给了右区间
                left = mid + 1;
            }
        }
        System.out.printf("left: %d, right: %d\n", left, right);
        if (right >= 0 && nums[right] == target) return right;
        else return -1;
    }

    @Deprecated
    public int searchRightMost_existWhenLeftEqualsRight(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        while (left < right) {//终止条件：left==right
            System.out.printf("left: %d, right: %d\n", left, right);
            int mid = left + (right - left) / 2;//分成[0..mid-1],mid,[mid+1..len-1]来比较
            if (target >= nums[mid]) {//target在右区间，等于的条件划给了右区间
                left = mid;
            } else {//target在左区间
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
