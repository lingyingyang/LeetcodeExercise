package huawei;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 合并表记录
 */
public class Eight {
    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        SortedMap<Integer, Integer> map = new TreeMap<>();
        int n = Integer.parseInt(str.nextLine());
        for (int i = 0; i < n; i++) {
            String[] mid = str.nextLine().split(" ");
            addPare(map, mid);
        }
        System.out.println(mapToString(map));
    }

    private static String mapToString(SortedMap<Integer, Integer> map) {
        StringBuilder builder = new StringBuilder();
        for (SortedMap.Entry<Integer, Integer> e : map.entrySet()) {
            builder.append(e.getKey()).append(" ").append(e.getValue()).append("\r");
        }
        return builder.toString();
    }

    private static void addPare(SortedMap<Integer, Integer> map, String[] mid) {
        int key = Integer.parseInt(mid[0]);
        int value = Integer.parseInt(mid[1]);
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + value);
        } else {
            map.put(key, value);
        }
    }
}
