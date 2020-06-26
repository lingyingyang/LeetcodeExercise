package leetcode.mapset.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidWordAbbr {
    public static void main(String[] args) {
        String[] dict = {"deer", "door", "cake", "card"};
        ValidWordAbbr test = new ValidWordAbbr(dict);
        assertFalse(test.isUnique("dear"));
        assertTrue(test.isUnique("cart"));
        assertFalse(test.isUnique("cane"));
        assertTrue(test.isUnique("make"));
    }

    private final Map<String, Set<String>> dict = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String word : dictionary) {
            String abbr = toAbbr(word);
            Set<String> set = dict.getOrDefault(abbr, new HashSet<>());
            set.add(word);
            dict.put(abbr, set);
        }
    }

    private String toAbbr(String s) {
        if (s.length() < 3) return s;

        String item;
        int num = s.length() - 2;
        item = "" + s.charAt(0) + num + s.charAt(s.length() - 1);
        return item;
    }

    public boolean isUnique(String word) {
        String abbr = this.toAbbr(word);
        Set<String> words = dict.get(abbr);
        return words == null || (words.size() == 1 && words.contains(word));
    }
}
