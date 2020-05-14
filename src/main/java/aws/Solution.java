package aws;

import java.util.*;

// CLASS BEGINS, THIS CLASS IS REQUIRED
class Solution {
    public static void main(String[] args) {
        Solution t = new Solution();
        List<String> toys = Arrays.asList("a", "b", "c", "x", "y");
        List<String> quotes = Arrays.asList("a e e e", "a b d", "c d e f");
        ArrayList<String> out = t.popularNToys(5, 2, toys, 3, quotes);
        System.out.println(out.toString());
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> popularNToys(int numToys,
                                          int topToys,
                                          List<String> toys,
                                          int numQuotes,
                                          List<String> quotes) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(topToys, Comparator.comparingInt(n -> n[1]));
        HashMap<String, int[]/*[idx, count]*/> map = new HashMap<>();
        for (int i = 0; i < toys.size(); i++) {
            String toy = toys.get(i);
            map.put(toy, new int[]{i, 0});
        }

        for (String quote : quotes) {
            String[] words = quote.split(" ");
            for (String word : words) {
                if (map.containsKey(word.toLowerCase())) {
                    int[] item = map.get(word);
                    item[1] = item[1] + 1;
                    map.put(word, item);
                }
            }
        }

        ArrayList<String> ans = new ArrayList<>();
        map.forEach((k, v) -> {
            heap.add(v);
            if (heap.size() > topToys) {
                heap.poll();
            }
        });

        while (!heap.isEmpty()) {
            ans.add(toys.get(heap.poll()[0]));
        }
        Collections.reverse(ans);
        return ans;
    }
    // METHOD SIGNATURE ENDS
}
