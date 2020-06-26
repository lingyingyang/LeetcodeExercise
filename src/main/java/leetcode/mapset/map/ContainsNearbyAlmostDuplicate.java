package leetcode.mapset.map;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ContainsNearbyAlmostDuplicate {
    public static void main(String[] args) {
        int[] nums = {2147483647, -2147483647};
        boolean out = new ContainsNearbyAlmostDuplicate().containsNearbyAlmostDuplicate(nums, 1, 2147483647);
        assertFalse(out);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; (j - i) <= k && j < nums.length; j++) {
                long sub = Math.abs((long) nums[j] - (long) nums[i]);
                if (sub <= t) {
                    return true;
                }
            }
        }

        return false;
    }
}
