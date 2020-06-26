package leetcode.graph;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        //无向边其实就是2条有向边组成的
        Map<Node/*A*/, Node/*B*/> visited = new HashMap<>();
        return helper(visited, node);
    }

    private Node helper(Map<Node, Node> visited, Node node) {
        if (visited.containsKey(node)) return visited.get(node);

        Node copied = new Node(node.val);
        visited.put(node, copied);

        for (Node neighbor : node.neighbors) {
            copied.neighbors.add(this.helper(visited, neighbor));
        }
        return copied;
    }
}
