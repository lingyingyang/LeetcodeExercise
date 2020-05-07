package leetcode.list;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 时间复杂度：O(1)。该数据结构中，所有方法都具有恒定的时间复杂度。
 * <p>
 * 空间复杂度：O(N)，其中 N 是队列的预分配容量。循环队列的整个生命周期中，都持有该预分配的空间。
 */
public class MyCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue t = new MyCircularQueue(3);
        assertThat(t.enQueue(1)).isTrue();
        assertThat(t.enQueue(2)).isTrue();
        System.out.println(String.format("head: %d, count: %d, queue: %s", t.head, t.count, Arrays.toString(t.queue)));
        assertThat(t.enQueue(3)).isTrue();
        assertThat(t.enQueue(4)).isFalse();
        assertThat(t.Front()).isEqualTo(1);
        assertThat(t.Rear()).isEqualTo(3);
        assertThat(t.isFull()).isTrue();
        assertThat(t.deQueue()).isTrue();
        assertThat(t.enQueue(4)).isTrue();
        assertThat(t.Rear()).isEqualTo(4);
        for (int i = 0; i < 4; i++) {
            t.deQueue();
        }
        assertThat(t.isEmpty()).isTrue();
    }

    private final int[] queue;
    private int head;
    private int count;
    private final int capacity;
    private final ReentrantLock lock = new ReentrantLock();

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        head = 0;
        count = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        lock.lock();
        try {
            if (count == capacity) return false;

            int next = (head + count) % capacity;
            queue[next] = value;
            count++;
        } finally {
            lock.unlock();
        }
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (count == 0) return false;
        head = (head + 1) % capacity;
        count--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (count == 0) return -1;
        return queue[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (count == 0) return -1;
        return queue[(head + count - 1) % capacity];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return count == capacity;
    }
}
