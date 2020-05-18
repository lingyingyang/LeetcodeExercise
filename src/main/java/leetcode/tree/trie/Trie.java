package leetcode.tree.trie;

import leetcode.tree.TrieNode;

import static org.assertj.core.api.Assertions.assertThat;

public class Trie {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        assertThat(t.search("apple")).isTrue();
        assertThat(t.search("app")).isFalse();
        assertThat(t.startsWith("app")).isTrue();
        t.insert("app");
        assertThat(t.search("app")).isTrue();
    }

    private final TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        return root;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {//不包括，插入
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {//不包括
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.children.containsKey(c)) {//不包括
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }
}