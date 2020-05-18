package leetcode.tree.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWord {
    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        String out = new ReplaceWord().replaceWords(dict, sentence);
        System.out.println(out);
    }

    public String replaceWords(List<String> dict, String sentence) {
        Trie t = new Trie();
        for (String root : dict) {
            t.insert(root);
        }

        String[] words = sentence.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            Trie.Result result = t.startIncludedIn(words[i]);
            if (!result.isIncluded) continue;
            words[i] = result.word;
        }

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append(" ");
        }
        return sb.toString().trim();
    }

    static class TrieNode {
        public String word;
        public Map<Character, TrieNode> children = new HashMap<>();
    }

    static class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!cur.children.containsKey(c)) {//不包括，插入
                    cur.children.put(c, new TrieNode());
                }
                cur = cur.children.get(c);
            }
            cur.word = word;
        }

        public TrieNode getRoot() {
            return root;
        }

        public Result startIncludedIn(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!cur.children.containsKey(c)) {//不包括
                    return new Result(false, null);
                }
                cur = cur.children.get(c);
                if (cur.word != null) return new Result(true, cur.word);
            }
            return new Result(false, null);
        }

        static class Result {
            public boolean isIncluded;
            public String word;

            public Result(boolean isIncluded, String word) {
                this.isIncluded = isIncluded;
                this.word = word;
            }
        }
    }
}
