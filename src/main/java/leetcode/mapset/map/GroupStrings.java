package leetcode.mapset.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupStrings {
    public static void main(String[] args) {
//        System.out.println('y' - 'a');
        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> out = new GroupStrings().groupStrings(strings);
        for (List<String> line : out) {
            System.out.println(line.toString());
        }
    }

    public List<List<String>> groupStrings(String[] strings) {
        if (strings.length == 0) return new ArrayList<>();

        Map<String/*pattern*/, List<String>> map = new HashMap<>();
        for (String item : strings) {
            StringBuilder sb = new StringBuilder();
            sb.append(item.length()).append("|");
            for (int j = 1; j < item.length(); j++) {
                int distance = (item.charAt(j) - item.charAt(j - 1) + 26) % 26;
                sb.append(distance).append("|");
            }
            String pattern = sb.toString();

            if (map.containsKey(pattern)) {
                map.get(pattern).add(item);
            } else {
                List<String> list = new ArrayList<>();
                list.add(item);
                map.put(pattern, list);
            }
        }

        return new ArrayList<>(map.values());
    }
}
