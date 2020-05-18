package leetcode.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DominantIndex {
    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 0};
        int out = new DominantIndex().dominantIndex(nums);
        System.out.println(out);
    }

    public int dominantIndex(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return 0;

        PriorityQueue<int[]/*[idx,value]*/> maxHeap = new PriorityQueue<>(2,
                Comparator.comparingInt(o -> o[1]));
        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(new int[]{i, nums[i]});
            if (maxHeap.size() > 2) maxHeap.poll();
        }

        int[] largest2 = maxHeap.poll();
        int[] largest = maxHeap.poll();
        if (largest[1] - largest2[1] >= largest2[1]) return largest[0];
        return -1;
    }
}
