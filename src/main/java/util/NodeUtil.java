package util;

import leetcode.tree.ListNode;

public class NodeUtil {
    public static String print(ListNode root) {
        StringBuffer out = new StringBuffer();
        while (root != null) {
            out.append(String.format("%d -> ", root.val));
            root = root.next;
        }
        return out.toString();
    }
}
