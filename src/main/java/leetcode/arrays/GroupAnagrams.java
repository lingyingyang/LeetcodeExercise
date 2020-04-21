package leetcode.arrays;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams t = new GroupAnagrams();
        String[] ins = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> out = t.groupAnagrams(ins);
        out.forEach(item -> System.out.println(item.toString()));
    }

    public List<List<String>> groupAnagrams(String[] ins) {
        if (ins.length == 0) return new ArrayList<>();

        Map<String, List<String>> ans = new HashMap<>();
        for (String str : ins) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            List<String> item = ans.getOrDefault(key, new ArrayList<>());
            item.add(str);
            ans.put(key, item);
        }
        return new ArrayList<>(ans.values());
    }
}
