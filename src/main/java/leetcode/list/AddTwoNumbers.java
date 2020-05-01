package leetcode.list;

import leetcode.tree.ListNode;
import util.NodeUtil;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers t = new AddTwoNumbers();
        ListNode root = t.addTwoNumbers(l1, l2);
        NodeUtil.print(root);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int pVal = (p != null) ? p.val : 0;
            int qVal = (q != null) ? q.val : 0;
            int sum = carry + pVal + qVal;//如果carry>1,会在下一个节点加上
            carry = sum / 10;//如果大于10，等于1
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
