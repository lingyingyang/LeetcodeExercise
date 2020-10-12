package leetcode.linkedlist.model.multidual;

import util.NodeUtil;

import java.util.Stack;

public class Fatten {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.child = new Node(3);
        Node out = new Fatten().flatten(head);
        NodeUtil.print(out);
    }

    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node prev = new Node(-1);
        prev.next = head;
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) { // 有child
                if (curr.next != null) // 如果当前层数的next不是null，才入栈
                    stack.push(curr.next);
                // 双向连接child
                curr.next = curr.child;
                curr.next.prev = curr;
                curr.child = null; // 清除child
            } else if (curr.next == null && !stack.isEmpty()) { // 到当前层的最后一个节点且stack里有记录
                // 双向连接上一层的下一个节点
                curr.next = stack.pop();
                curr.next.prev = curr;
            }
            curr = curr.next;
            prev = prev.next;
        }
        return head;
    }
}
