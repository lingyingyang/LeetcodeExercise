package leetcode.tree.trie;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 每个节点包括所有单词重复的字母的count，这样sum()的时候只需要查询到val的最后一个字符就可以了
 */
public class MapSum {
    public static void main(String[] args) {
        MapSum t = new MapSum();
        t.insert("apple", 3);
        assertThat(t.sum("apple")).isEqualTo(3);
        assertThat(t.sum("ap")).isEqualTo(3);
        t.insert("app", 2);
        assertThat(t.sum("ap")).isEqualTo(5);
        assertThat(t.sum("apple")).isEqualTo(3);
    }

    private final TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    /**
     * 用当前char的下一位来存储count&isWord
     *
     * @param key
     * @param val
     */
    public void insert(String key, int val) {
        TrieNode cur = root;
        SearchResult result = search(key);
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
            if (!result.isContains) {//不包括这个word
                cur.count += val;
            } else {//包括这个word，取代其count
                cur.count += val - result.node.count;
            }
        }
        cur.isWord = true;
    }

    public SearchResult search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {//不包括
                return new SearchResult(null, false);
            }
            cur = cur.children.get(c);
        }
        return new SearchResult(cur, cur.isWord);
    }

    /**
     * 用当前char的下一位来存储count&isWord
     *
     * @param prefix
     * @return
     */
    public int sum(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.children.containsKey(c)) {
                return 0;
            }
            cur = cur.children.get(c);
        }
        return cur.count;
    }

    static class TrieNode {
        public boolean isWord;
        public int count;
        public Map<Character, TrieNode> children = new HashMap<>();
    }

    static class SearchResult {
        public TrieNode node;
        public boolean isContains;

        public SearchResult(TrieNode node, boolean isContains) {
            this.node = node;
            this.isContains = isContains;
        }
    }
}
