package leetcode.arrays;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveZero {
    public static void main(String[] args) {
        MoveZero t = new MoveZero();
//        int[] nums = {0, 1, 0, 3, 12};
//        t.moveZeroes(nums);
//        System.out.println(Arrays.toString(nums));

//        int out = t.removeElement(nums, 0);
//        assertEquals(3, out);
//        System.out.println(Arrays.toString(nums));

        int[] nums = {1, 1, 1, 2, 2, 3};
        int len = t.removeDuplicates(nums);
        assertEquals(5, len);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        if (nums.length == 0) return;
        //1 fast遇到非零时，与slow互换
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                swap(nums, slow, fast);
                slow++;
            }
            fast++;
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int slow = 1, count = 1;

        for (int fast = 1; fast < nums.length; fast++) {
            // If the current element is a duplicate, increment the count.
            if (nums[fast] == nums[fast - 1]) {
                count++;
            } else {
                // Reset the count since we encountered a different element
                // than the previous one.
                count = 1;
            }

            // For a count <= 2, we copy the element over thus
            // overwriting the element at index "slow" in the array
            if (count <= 2) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public int removeElement(int[] nums, int val) {
        int ans = 0;
        if (nums.length == 0) return 0;

        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                swap(nums, slow, fast);
                slow++;
                ans++;
            }
            fast++;
        }
        return ans;
    }

    private void swap(int[] nums, int slow, int fast) {
        int tmp = nums[slow];
        nums[slow] = nums[fast];
        nums[fast] = tmp;
    }
}
