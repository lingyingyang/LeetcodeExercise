package leetcode.linkedlist;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue =
                new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (ListNode node : lists) { // 把每个链表的第一个节点放入queue中
            if (node != null) queue.add(node);
        }

        while (!queue.isEmpty()) {
            // 获取并删除queue的第一个节点；
            // 并把curr连接上当前节点；
            curr.next = queue.poll();
            curr = curr.next; // move curr cursor to next
            if (curr.next != null) queue.add(curr.next);
        }
        return dummy.next;
    }

    public ListNode mergeKLists(List<ListNode> in) {
        if (in == null || in.size() == 0) return null;

        PriorityQueue<ListNode> queue =
                new PriorityQueue<>(in.size(), Comparator.comparingInt(o -> o.val));

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (ListNode node : in) {
            if (node != null) queue.add(node);
        }

        while (!queue.isEmpty()) {
            curr.next = queue.poll(); // retrieve and remove the first element of queue
            curr = curr.next; // move curr cursor to next

            if (curr.next != null) queue.add(curr.next);
        }
        return dummy.next;
    }
}
