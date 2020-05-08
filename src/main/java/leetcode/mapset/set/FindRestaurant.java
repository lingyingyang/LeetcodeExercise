package leetcode.mapset.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindRestaurant {
    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] out = new FindRestaurant().findRestaurant(list1, list2);
        System.out.println(Arrays.toString(out));
        assertThat(Arrays.toString(out)).isEqualTo("[Shogun]");
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                String s1 = list1[i];
                String s2 = list2[j];
                if (s1.equals(s2)) {
                    int idxSum = i + j;
                    List<String> list = map.getOrDefault(idxSum, new ArrayList<>());
                    list.add(s1);
                    map.put(idxSum, list);
                }
            }
        }
        int minIdx = Integer.MAX_VALUE;
        for (Integer key : map.keySet()) {
            minIdx = Math.min(key, minIdx);
        }
        return map.get(minIdx).toArray(new String[0]);
    }
}
