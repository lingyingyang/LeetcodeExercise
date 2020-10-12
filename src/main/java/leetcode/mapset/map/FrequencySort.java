package leetcode.mapset.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FrequencySort {
    public static void main(String[] args) {
        String s = "tree";
        String out = new FrequencySort().frequencySort(s);
        System.out.println(out);
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        map.entrySet().stream()
           .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
           .forEach(
                   entry -> {
                       for (int i = 0; i < entry.getValue(); i++) {
                           sb.append(entry.getKey());
                       }
                   });
        return sb.toString();
    }
}
