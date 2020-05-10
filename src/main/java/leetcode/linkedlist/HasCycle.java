package leetcode.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

public class HasCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        head.next.next = new ListNode(4);
        head.next.next.next = node2;
        boolean out = new HasCycle().hasCycle(head);
        assertThat(out).isTrue();
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }
}
