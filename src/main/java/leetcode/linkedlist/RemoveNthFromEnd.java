package leetcode.linkedlist;

import util.NodeUtil;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        RemoveNthFromEnd t = new RemoveNthFromEnd();
        ListNode out = t.removeNthFromEnd(head, 2);
        NodeUtil.print(out);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode pioneer = dump;
        ListNode curr = dump;
        for (int i = 0; i < n; i++) {
            pioneer = pioneer.next;
        }

        while (pioneer.next != null) { // 是否到达尾部
            pioneer = pioneer.next;
            curr = curr.next;
        }
        curr.next = curr.next.next; // 删除倒数第n个节点

        return dump.next;
    }
}
