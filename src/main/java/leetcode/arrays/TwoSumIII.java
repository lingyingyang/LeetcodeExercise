package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TwoSumIII {
    public static void main(String[] args) {
        TwoSumIII test = new TwoSumIII();
        test.add(0);
        test.add(0);
        assertTrue(test.find(0));
    }

    private final Map<Integer /*value*/, Integer /*count*/> map;

    /**
     * Initialize your data structure here.
     */
    public TwoSumIII() {
        map = new HashMap<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (int number : map.keySet()) {
            int sub = value - number;
            if (map.containsKey(sub)) {
                if (sub == number) {
                    if (map.get(sub) > 1) return true;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
