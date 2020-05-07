package leetcode.queuestack.queue;

import java.util.LinkedList;

public class LimitQueue<E> {

    private final int capacity; // 队列容量

    private final LinkedList<E> queue = new LinkedList<E>();

    public LimitQueue(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 入列：当队列大小已满时，把队头的元素poll掉
     */
    public void offer(E e) {
        if (queue.size() >= capacity) {
            queue.poll();
        }
        queue.offer(e);
    }

    public E get(int position) {
        return queue.get(position);
    }

    public E getLast() {
        return queue.getLast();
    }

    public E getFirst() {
        return queue.getFirst();
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return queue.size();
    }
}
