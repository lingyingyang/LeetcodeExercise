package leetcode.mapset.map;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        boolean out = new ContainsNearbyDuplicate().containsNearbyDuplicate(nums, k);
        assertThat(out).isTrue();
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer /*第一次出现的item*/, Integer /*idx*/> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if ((i - map.get(nums[i])) <= k) {
                    return true;
                } else { // 替换之前的idx，考虑到后面有可能的情况
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
