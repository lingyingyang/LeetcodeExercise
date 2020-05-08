package skiplist;

import java.util.concurrent.ConcurrentSkipListMap;

public class SkipListMapDemo {
    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer, Integer> skipListMap = new ConcurrentSkipListMap<>();
        for (int i = 0; i < 10; i++) {
            skipListMap.put(i, i);
        }

        //有序性
        for (Integer key : skipListMap.keySet()) {
            System.out.println(key);
        }
    }
}
