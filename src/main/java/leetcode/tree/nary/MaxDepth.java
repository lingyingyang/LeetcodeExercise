package leetcode.tree.nary;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaxDepth {
    public static void main(String[] args) {
        MaxDepth t = new MaxDepth();
        Node root = new Node(1);
        List<Node> level2 = root.children = new ArrayList<>();
        Node node2 = new Node(2);
        level2.add(node2);
        level2.add(new Node(3));
        List<Node> level3 = node2.children = new ArrayList<>();
        level3.add(new Node(4));
        level3.add(new Node(5));

        int out = t.maxDepth(root);
        System.out.println(out);
    }

    public int maxDepth(Node root) {
//        preorderHelper(root, 1);
//        return ans;

//        return postorderHelper(root);

        return byStack(root);
    }

    private int ans;

    /**
     * 先序遍历，其实也是"自顶向下"的递归函数
     *
     * @param root
     * @return
     */
    private void preorderHelper(Node root, int depth) {
        if (root == null) return;
        if (root.children == null) {//叶子节点
            ans = Math.max(ans, depth);
            return;
        }

        for (Node child : root.children) {
            preorderHelper(child, depth + 1);
        }
    }


    /**
     * 后序遍历，其实也是"自底向上"的递归函数
     *
     * @param root
     * @return
     */
    private int postorderHelper(Node root) {
        if (root == null) return 0;

        int depth = 0;
        for (Node child : root.children) {
            depth = Math.max(postorderHelper(child), depth);
        }
        return depth + 1;
    }

    private int byStack(Node root) {
        if (root == null) return 0;
        LinkedList<Pair<Node, Integer/*current depth*/>> stack = new LinkedList<>();
        stack.offer(new Pair<>(root, 1));

        int maxDepth = 0;
        while (!stack.isEmpty()) {
            Pair<Node, Integer> point = stack.poll();
            Node node = point.getKey();
            Integer depth = point.getValue();

            maxDepth = Math.max(maxDepth, depth);
            if (node.children != null) {
                for (Node child : node.children) {
                    stack.offer(new Pair<>(child, depth + 1));
                }
            }
        }
        return maxDepth;
    }
}
