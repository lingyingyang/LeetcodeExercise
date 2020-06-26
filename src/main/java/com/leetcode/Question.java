package com.leetcode;

public class Question {
    public int[] runningSum(int[] nums) {
        if (nums == null) return null;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
