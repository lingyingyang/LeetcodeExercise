package leetcode.linkedlist;

import util.NodeUtil;

public class RotateRight {
    public static void main(String[] args) {
        ListNode head = NodeUtil.createListNode(new int[]{1, 2, 3, 4, 5});
        ListNode out = new RotateRight().rotateRight(head, 2);
        NodeUtil.print(out);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;

        ListNode firstRound = head;
        int len = 1;
        // 到达链表尾部，并得到len
        while (firstRound.next != null) {
            firstRound = firstRound.next;
            len++;
        }
        // 链表首尾连接
        ListNode end = firstRound;
        firstRound.next = head;
        // k%len可映射全部k大于len的情况，len-k%len可得到新的尾节点还需要移动几步
        for (int i = 0; i < (len - k % len); i++) {
            end = end.next;
        }
        ListNode start = end.next; // 未节点的next就是新链表的首节点
        end.next = null; // 断开环形链表
        return start;
    }

    /**
     * 如果k很大，OOM
     *
     * @param head
     * @param k
     * @return
     */
    @Deprecated
    public ListNode rotateRightDeprecated(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            while (true) {
                if (curr.next == null) { // 到达最后一个节点
                    curr.next = head;
                    prev.next = null;
                    head = curr;
                    prev = new ListNode(-1);
                    prev.next = curr;
                    break;
                } else {
                    curr = curr.next;
                    prev = prev.next;
                }
            }
        }
        return curr;
    }
}
