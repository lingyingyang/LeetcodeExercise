package leetcode.linkedlist;

import util.NodeUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome t = new IsPalindrome();
        assertThat(t.isPalindrome(NodeUtil.createListNode(new int[]{1, 2}))).isFalse();
        assertThat(t.isPalindrome(NodeUtil.createListNode(new int[]{1, 2, 2, 1}))).isTrue();
        assertThat(t.isPalindrome(NodeUtil.createListNode(new int[]{1, 2, 1}))).isTrue();
    }

    /**
     * 时间复杂度：O(n)，其中 n 指的是链表的大小。
     * 空间复杂度：O(1)，我们是一个接着一个的改变指针，我们在堆栈上的堆栈帧不超过 O(1)。
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {//fast后面有两节点才移动
            fast = fast.next.next;//fast移动2步
            slow = slow.next;//slow移动1步
        }
        ListNode secondEnd = slow.next;
        ListNode secondStart = reverseList(secondEnd);
        ListNode firstStart = head;
        ListNode secondDump = secondStart;
        boolean ans = true;
        while (secondStart != null) {//secondStart的长度<=firstStart的长度
            if (firstStart.val != secondStart.val) ans = false;
            firstStart = firstStart.next;
            secondStart = secondStart.next;
        }

        reverseList(secondDump);//保持输入head的不变形
        return ans;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }
        return prev;
    }
}
