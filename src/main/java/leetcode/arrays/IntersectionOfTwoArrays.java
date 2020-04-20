package leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2, 3};
        IntersectionOfTwoArrays t = new IntersectionOfTwoArrays();
        int[] out = t.intersect(nums1, nums2);
        System.out.println(Arrays.toString(out));//2, 2
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        //1如果nums1比nums2长，swap
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        //2用HashMap来做match
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //3复制匹配的值到nums1中，并输出前idx位匹配的值
        int idx = 0;
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                map.put(num, map.get(num) - 1);
                nums1[idx++] = num;
            }
        }
        return Arrays.copyOfRange(nums1, 0, idx);
    }
}
