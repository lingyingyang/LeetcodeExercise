package leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Intersection {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        Intersection t = new Intersection();
        int[] out = t.intersection(nums1, nums2);
        assertThat(Arrays.toString(out)).isEqualTo("[2]");
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[]{};

        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }

        if (set2.size() > set1.size()) {
            return helper(nums1, set2, set1);
        } else {
            return helper(nums1, set1, set2);
        }
    }

    private int[] helper(int[] nums1, Set<Integer> set1, Set<Integer> set2) {
        int idx = 0;
        for (Integer item : set1) {
            if (set2.contains(item)) {
                nums1[idx++] = item;
            }
        }
        return Arrays.copyOfRange(nums1, 0, idx);
    }
}
