package leetcode.queuestack.queue;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingAverage {
    public static void main(String[] args) {
        MovingAverage t = new MovingAverage(3);
        assertThat(t.next(1)).isEqualTo(1.0);
        assertThat(t.next(10)).isEqualTo(5.5);
        assertThat(t.next(3)).isEqualTo(4.666666666666667);
        assertThat(t.next(5)).isEqualTo(6.0);
    }

    private final LinkedList<Integer> queue;
    private final int capacity;
    private int sum;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.queue = new LinkedList<Integer>();
        this.capacity = size;
    }

    public double next(int val) {
        if (queue.size() == capacity) { // 超过了capacity，删除head
            sum -= queue.remove();
        }

        queue.offer(val);
        sum += val;
        return (double) sum / queue.size();
    }
}
