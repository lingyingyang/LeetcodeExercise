package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindKthLargest {
    public static void main(String[] args) {
        FindKthLargest t = new FindKthLargest();
        int[] nums = {3, 2, 1, 5, 6, 4};
        assertEquals(5, t.findKthLargest(nums, 2));
    }

    /**
     * 时间复杂度 : O(N log k)。像大小为 k 的堆中添加元素的时间复杂度为 O(log k)，我们将重复该操作 N 次
     *
     * <p>空间复杂度 : O(k)，用于存储堆元素。
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n));

        // keep k largest elements in the heap
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        // output
        return heap.poll();
    }
}
