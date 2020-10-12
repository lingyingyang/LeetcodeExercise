package leetcode.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(0);
        ListNode node = new ListNode(2);
        node.next = new ListNode(8);
        headA.next.next = node;
        ListNode headB = new ListNode(3);
        headB.next = node;

        ListNode out = new GetIntersectionNode().getIntersectionNode(headA, headB);
        System.out.println(out.val);
        assertThat(out.val).isEqualTo(2);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode aPointer = headA;
        ListNode bPointer = headB;
        while (aPointer != bPointer) {
            // 遍历完一条链表后交换pointer，如果有交点，两个pointer就会碰到
            aPointer = (aPointer == null) ? headB : aPointer.next;
            bPointer = (bPointer == null) ? headA : bPointer.next;
        }
        return aPointer;
    }
}
