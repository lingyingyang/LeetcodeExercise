package leetcode.tree.nary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Codec {
  /*public static void main(String[] args) {
      Node root = new Node();
      List<Node> children = new ArrayList<>();
      for (int i = 0; i < 3; i++) {
          if (i == 0) {
              Node node = new Node(i + 2);
              node.children = new ArrayList<>();
              children.add(node);
              for (int j = 0; j < 2; j++) {
                  Node child = new Node(j + 5);
                  node.children.add(child);
              }
          } else {
              children.add(new Node(i + 2));
          }
      }
      root.val = 1;
      root.children = children;
      Codec test = new Codec();
      String out = test.serialize(root);
      assertEquals("1,null,2,3,4,null,5,6", out);
      Node node = test.deserialize(out);
      assertEquals(1, node.val);
      assertEquals(3, node.children.size());
      assertEquals(2, node.children.get(0).children.size());
  }

  // Encodes a tree to a single string.
  public String serialize(Node root) {
      if (root == null) return "";
      StringBuilder sb = new StringBuilder();
      Queue<Node> q = new LinkedList<>();
      q.offer(root);
      while (!q.isEmpty()) {
          int levelNum = q.size();
          for (int i = 0; i < levelNum; i++) {
              Node node = q.poll();
              if (node.children != null && !node.children.isEmpty()) {
                  for (Node child : node.children) {
                      q.offer(child);
                  }
              }
              sb.append(node.val).append(",");
          }
          sb.append("null,");
      }
      String ans = sb.toString();
      return ans.substring(0, ans.lastIndexOf(",null,"));
  }

  private void encode(Node root, StringBuilder sb) {
      if (root == null) return;

      sb.append(root.val).append(",");
      if (root.children != null && !root.children.isEmpty()) {
          sb.append("null,");
          for (Node child : root.children) {
              encode(child, sb);
          }
      }
  }*/

    public static void main(String[] args) {
        Node root = new Node();
        List<Node> children = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            children.add(new Node(i + 2));
        }
        root.val = 1;
        root.children = children;
        Codec test = new Codec();
        String out = test.serialize(root);
        assertEquals("1 [ 2 3 4 ]", out);
        Node node = test.deserialize(out);
        assertEquals(1, node.val);
        assertEquals(3, node.children.size());
    }

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    private void encode(Node root, StringBuilder sb) {
        if (root == null) return;

        sb.append(root.val).append(" ");
        boolean hasChildren = root.children != null && !root.children.isEmpty();
        if (hasChildren) {
            sb.append("[ ");
            for (Node child : root.children) {
                encode(child, sb);
            }
            sb.append("]");
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null) return null;

        LinkedList<Node> stack = new LinkedList<>();
        Node root = null;
        Node curr = null;
        String[] arr = data.split(" ");
        for (String s : arr) {
            if (s.equals("[")) {
                stack.push(curr);
            } else if (s.equals("]")) {
                stack.pop();
            } else {
                Node node = new Node();
                node.val = Integer.parseInt(s);
                node.children = new LinkedList<>();
                if (root == null) {
                    root = node;
                } else {
                    Node parent = stack.peek();
                    parent.children.add(node);
                }
                curr = node;
            }
        }
        return root;
    }
}
