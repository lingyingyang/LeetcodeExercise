package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class DetectCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = node2;

        ListNode out = new DetectCycle().detectCycle(head);
        assertThat(out.val).isEqualTo(2);
    }

    public ListNode detectCycle(ListNode node) {
        Set<ListNode> seen = new HashSet<>();
        while (node != null) {
            if (seen.contains(node))//发现第一个重复的节点
                return node;
            else
                seen.add(node);
            node = node.next;
        }
        return null;//没有闭环
    }
}
