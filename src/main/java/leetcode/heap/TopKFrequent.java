package leetcode.heap;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] out = new TopKFrequent().topKFrequent(nums, 2);
        System.out.println(Arrays.toString(out));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer/*number*/, Integer/*count*/> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator
                .comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] ans = new int[queue.size()];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : queue) {
            ans[idx++] = entry.getKey();
        }
        return ans;
    }
}
