package leetcode.linkedlist;

import util.NodeUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class OddEvenList {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = NodeUtil.createListNode(nums);
        ListNode out = new OddEvenList().oddEvenList(head);
        assertThat(NodeUtil.print(out)).isEqualTo("1 -> 3 -> 5 -> 2 -> 4 -> ");
    }

    /**
     * 时间复杂度： O(n) 。总共有 n 个节点，我们每个遍历一次。 空间复杂度： O(1) 。我们只需要 4 个指针。
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next; // odd指向下一个odd
            odd = odd.next; // odd指针跳到下一个odd
            even.next = odd.next; // even指向一个even
            even = even.next; // even指针跳到下一个even
        }
        odd.next = evenHead; // 缝接odd和even
        return head;
    }
}
