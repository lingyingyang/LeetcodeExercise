package leetcode.arrays;

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i > -1 && j > -1) A[k--] = (A[i] > B[j]) ? A[i--] : B[j--];
        while (j > -1) A[k--] = B[j--];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
