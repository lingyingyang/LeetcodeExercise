package leetcode.queuestack.queue;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 用队列实现栈
 */
public class MyStack {
    public static void main(String[] args) {
        MyStack q = new MyStack();
        q.push(1);
        q.push(2);
        assertThat(q.top()).isEqualTo(2);
        assertThat(q.pop()).isEqualTo(2);
        assertThat(q.empty()).isFalse();
    }

    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int top;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        q1.add(x);
        top = x;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while (q1.size() > 1) {
            top = q1.remove();
            q2.add(top);
        }
        Integer ans = q1.remove();
        //swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return ans;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return top;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return q1.isEmpty();
    }
}
