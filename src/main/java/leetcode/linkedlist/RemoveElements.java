package leetcode.linkedlist;

public class RemoveElements {
    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode prev = dump, curr = head;
        while (curr != null) {
            if (curr.val == val)
                prev.next = curr.next;
            else
                prev = curr;
            curr = curr.next;
        }
        return dump.next;
    }
}
