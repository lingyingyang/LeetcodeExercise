package leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int num : nums) {
            if (!set.add(num)) {
                ans = num;
            }
        }
        return ans;
    }
}
