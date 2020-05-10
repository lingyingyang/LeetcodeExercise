package util;

import leetcode.linkedlist.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NodeUtilTest {
    @Test
    void whenCreateListNode_thenOk() {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = NodeUtil.createListNode(nums);
        assertThat(NodeUtil.print(head)).isEqualTo("1 -> 2 -> 3 -> 4 -> 5 -> ");
    }
    //    @Test
//    void genTree() {
//        int[] nums = {1, 2, 3, 4, -1, -1, 5};
//        NodeUtil.genTree()
//    }
}