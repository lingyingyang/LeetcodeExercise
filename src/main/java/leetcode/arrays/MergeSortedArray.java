package leetcode.arrays;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] A, int m, int[] B, int n) {
        int idxM = m - 1, idxN = n - 1, i = m + n - 1;
        while (idxM > -1 && idxN > -1) {
            A[i--] = (A[idxM] > B[idxN]) ? A[idxM--] : B[idxN--];
        }
        while (idxN > -1) {
            A[i--] = B[idxN--];
        }
    }
}
