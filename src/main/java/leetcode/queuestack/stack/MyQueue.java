package leetcode.queuestack.stack;

import java.util.Stack;

public class MyQueue {
    private int front;
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (s1.empty()) front = x;

        while (!s1.isEmpty())
            s2.push(s1.pop());
        s2.push(x);
        while (!s2.isEmpty())
            s1.push(s2.pop());
    }

    // Removes the element from the front of queue.
    public int pop() {
        int ans = s1.pop();
        if (!s1.empty())
            front = s1.peek();
        return ans;
    }

    // Get the front element.
    public int peek() {
        return front;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty();
    }
}
