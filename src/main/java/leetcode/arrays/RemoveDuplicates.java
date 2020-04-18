package leetcode.arrays;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates t = new RemoveDuplicates();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = t.removeDuplicates(nums);
        System.out.println("Unique Array Length: " + len);
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] == nums[fast]) continue;//重复，跳过
            //1让slow指向下一个非重复值的index
            //2复制下一个非重复值给slow
            ++slow;
            nums[slow] = nums[fast];
        }
        return slow + 1;
    }
}
