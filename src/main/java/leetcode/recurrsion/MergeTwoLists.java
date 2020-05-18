package leetcode.recurrsion;

import leetcode.linkedlist.ListNode;
import util.NodeUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeTwoLists {
    public static void main(String[] args) {
        MergeTwoLists t = new MergeTwoLists();
        ListNode l1 = NodeUtil.createListNode(new int[]{1, 2, 4});
        ListNode l2 = NodeUtil.createListNode(new int[]{1, 3, 4});
//        ListNode out = t.mergeTwoLists(l1, l2);
//        ListNode out = t.byRecur(l1, l2);
        ListNode out = t.byIter(l1, l2);
        NodeUtil.print(out);
    }

    public ListNode byIter(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(-1);
        ListNode prev = dump;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return dump.next;
    }

    public ListNode byRecur(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = byRecur(l1.next, l2);
            return l1;
        } else {
            l2.next = byRecur(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<ListNode> in = new ArrayList<>();
        in.add(l1);
        in.add(l2);
        return mergeKLists(in);
    }

    private ListNode mergeKLists(List<ListNode> in) {
        if (in == null || in.size() == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(in.size(),
                Comparator.comparingInt(o -> o.val));

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (ListNode node : in) {
            if (node != null)
                queue.add(node);
        }

        while (!queue.isEmpty()) {
            curr.next = queue.poll(); // retrieve and remove the first element of queue
            curr = curr.next; // move curr cursor to next

            if (curr.next != null)
                queue.add(curr.next);
        }
        return dummy.next;
    }
}
