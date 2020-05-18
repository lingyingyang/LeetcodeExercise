package leetcode.tree.nary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NAryTreeTraversal {

    private List<Integer> ans;

    public List<Integer> preorder(Node root) {
        ans = new ArrayList<>();
        preorderByRecur(root);
        return ans;
    }

    private void preorderByRecur(Node root) {
        if (root == null) return;

        ans.add(root.val);
        for (Node child : root.children) {
            preorderByRecur(child);
        }
    }

    public List<Integer> postorder(Node root) {
        ans = new ArrayList<>();
        postorderByRecur(root);
        return ans;
    }

    private void postorderByRecur(Node root) {
        if (root == null) return;
        for (Node child : root.children) {
            postorderByRecur(child);
        }
        ans.add(root.val);
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();

        LinkedList<Node> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelNum = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                Node curr = q.poll();
                level.add(curr.val);
                for (Node child : curr.children) {
                    q.offer(child);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
