package list;

import tree.ListNode;
import util.NodeUtil;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeSortedLists {
    public ListNode mergeKLists(ListNode[] in) {
        if (in == null || in.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(in.length,
                Comparator.comparingInt(o -> o.val));

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : in) {
            if (node != null)
                queue.add(node);
        }

        while (!queue.isEmpty()) {
            System.out.print("queue: ");
            queue.stream().forEach(item -> System.out.print(String.format("%d -> ", item.val)));
            System.out.println();
            System.out.println("result: " + NodeUtil.print(dummy));

            tail.next = queue.poll(); // retrieve and remove the first element of queue
            tail = tail.next; // move tail cursor to next

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    public ListNode mergeKLists(List<ListNode> in) {
        if (in == null || in.size() == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(in.size(),
                Comparator.comparingInt(o -> o.val));

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : in) {
            if (node != null)
                queue.add(node);
        }

        queue.stream().forEach(item -> System.out.print(String.format("%d -> ", item.val)));
        System.out.println("======");

        while (!queue.isEmpty()) {
            System.out.print("queue: ");
            queue.stream().forEach(item -> System.out.print(String.format("%d -> ", item.val)));
            System.out.println();
            System.out.println("result: " + NodeUtil.print(dummy));

            tail.next = queue.poll(); // retrieve and remove the first element of queue
            tail = tail.next; // move tail cursor to next

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
