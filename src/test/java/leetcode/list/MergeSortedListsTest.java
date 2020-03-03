package leetcode.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import leetcode.tree.ListNode;
import util.NodeUtil;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MergeSortedListsTest {
    @Test
    void whenTest_givenArrayInput_thenOk() {
        MergeSortedLists test = new MergeSortedLists();
        ListNode[] in = new ListNode[3];
        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(4);
        root1.next.next = new ListNode(5);
        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(3);
        root2.next.next = new ListNode(4);
        ListNode root3 = new ListNode(2);
        root3.next = new ListNode(6);
        in[0] = root1;
        in[1] = root2;
        in[2] = root3;

        ListNode out = test.mergeKLists(in);
        String actual = NodeUtil.print(out);
        log.info("actual out: {}", actual);
        String expect = "1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6 -> ";
        assertEquals(expect, actual);
    }

    @Test
    void whenTest_givenListInput_thenOk() {
        MergeSortedLists test = new MergeSortedLists();
        List<ListNode> in = new ArrayList<>();
        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(4);
        root1.next.next = new ListNode(5);
        in.add(root1);
        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(3);
        root2.next.next = new ListNode(4);
        in.add(root2);
        ListNode root3 = new ListNode(2);
        root3.next = new ListNode(6);
        in.add(root3);

        ListNode out = test.mergeKLists(in);
        String actual = NodeUtil.print(out);
        String expect = "1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6 -> ";
        assertEquals(expect, actual);
    }
}