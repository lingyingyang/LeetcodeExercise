package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public boolean isWord;
    public Map<Character, TrieNode> children = new HashMap<>();

    public boolean containsChild(char c) {
        return children.containsKey(c);
    }
}
