package leetcode.recurrsion;

import leetcode.linkedlist.ListNode;
import util.NodeUtil;

public class SwapPairs {
    public static void main(String[] args) {
        ListNode head = NodeUtil.createListNode(new int[]{1, 2, 3, 4});
        ListNode out = new SwapPairs().swapPairs(head);
        NodeUtil.print(out);
    }

    public ListNode swapPairs(ListNode head) {
        return helper(head);
    }

    private ListNode helper(ListNode head) {
        if (head == null || head.next == null) return head;

        // 自顶向下的操作，把first和second变成一个小黑盒，first指向下一个黑盒
        ListNode first = head;
        ListNode second = head.next;
        first.next = helper(second.next); // 递推关系
        // 自下向上的操作，把second指向first，然后当前黑盒返回second作为黑盒的连接点
        second.next = first;
        return second;
    }
}
