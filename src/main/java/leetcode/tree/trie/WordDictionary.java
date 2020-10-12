package leetcode.tree.trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WordDictionary {
    public static void main(String[] args) {
        WordDictionary t = new WordDictionary();
        t.addWord("bad");
        t.addWord("dad");
        t.addWord("mad");
        assertThat(t.search("pad")).isFalse();
        assertThat(t.search("bad")).isTrue();
        assertThat(t.search(".ad")).isTrue();
        assertThat(t.search("b..")).isTrue();

        t.clear();
        t.addWord("at");
        t.addWord("and");
        t.addWord("an");
        t.addWord("add");
        assertThat(t.search("a")).isFalse();

        t.clear();
        t.addWord("a");
        t.addWord("a");
        t.search(".");
        t.search("a");
        t.search("aa");
        t.search("a.");
        t.search(".a");

        t.clear();
        t.addWord("ran");
        t.addWord("rune");
        t.addWord("runner");
        t.addWord("runs");
        t.addWord("add");
        t.addWord("adds");
        t.addWord("adder");
        t.addWord("addee");
        assertThat(t.search("r.n")).isTrue();
    }

    public static final char ANY_CHAR = '.';
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode('-');
    }

    public void clear() {
        root = new TrieNode('-');
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.containsChild(c)) {
                cur.children.put(c, new TrieNode(c));
            }
            cur = cur.children.get(c);
            if (i == word.length() - 1) { // word的最后一位，标志word
                cur.isWord = true;
            }
        }
    }

    public boolean search(String word) {
        LinkedList<TrieNode> nodes = new LinkedList<>();
        nodes.offer(root);
        for (int idx = 0; idx < word.length(); idx++) { // 迭代每层
            char nextChar = word.charAt(idx);
            // 迭代每层level的全部nodes，然后用下一层的list替换当前层的list
            LinkedList<TrieNode> nextNodes = new LinkedList<>();
            for (TrieNode node : nodes) {
                // 如果不是特殊字符，nextNodes加上一个方向的数据
                if (nextChar != ANY_CHAR) {
                    if (node.containsChild(nextChar)) {
                        nextNodes.offer(node.children.get(nextChar));
                    }
                } else { // 如果是特殊字符，nextNodes加上所有方向的数据
                    for (TrieNode child : node.children.values()) {
                        nextNodes.offer(child);
                    }
                }
            }
            nodes = nextNodes;
            //            System.out.println(nodes.toString());
            // level到达最后word最后的idx
            if (idx == (word.length() - 1)) {
                for (TrieNode node : nodes) {
                    if (node.isWord) return true;
                }
            } else {
                if (nodes.isEmpty()) return false;
            }
        }
        return false;
    }

    static class TrieNode {
        public boolean isWord;
        public char val;
        public Map<Character, TrieNode> children = new HashMap<>();

        public TrieNode(char val) {
            this.val = val;
        }

        public boolean containsChild(char c) {
            return children.containsKey(c);
        }
    }
}
