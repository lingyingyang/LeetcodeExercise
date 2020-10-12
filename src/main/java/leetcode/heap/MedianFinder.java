package leetcode.heap;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 时间复杂度：O(logN)，优先队列的出队入队操作都是对数级别的，数据在两个堆中间来回操作是常数级别的， 综上时间复杂度是 O(logN) 级别的。
 *
 * <p>空间复杂度：O(N)，使用了三个辅助空间，其中两个堆的空间复杂度是 O(N/2)， 一个表示数据流元素个数的计数器 count，占用空间 O(1)，综上空间复杂度为 O(N)。
 */
public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder t = new MedianFinder();
        t.addNum(1);
        t.addNum(2);
        assertEquals(1.5, t.findMedian());
        t.addNum(3);
        assertEquals(2, t.findMedian());
    }

    /**
     * 当前大顶堆和小顶堆的元素个数之和
     */
    private int count;
    /**
     * 中位数左边的最大堆
     */
    private PriorityQueue<Integer> maxHeap;
    /**
     * 中位数右边的最小堆
     */
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        count = 0;
        maxHeap = new PriorityQueue<>((x, y) -> y - x);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count++;
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        // 如果两个堆合起来的元素个数是奇数，小顶堆要拿出堆顶元素给大顶堆
        if ((count & 1) != 0) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if ((count & 1) == 0) {
            // 如果两个堆合起来的元素个数是偶数，数据流的中位数就是各自堆顶元素的平均值
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            // 如果两个堆合起来的元素个数是奇数，数据流的中位数大顶堆的堆顶元素
            return (double) maxHeap.peek();
        }
    }
}
