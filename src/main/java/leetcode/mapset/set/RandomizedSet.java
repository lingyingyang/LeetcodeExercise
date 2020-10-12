package leetcode.mapset.set;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class RandomizedSet {
    public static void main(String[] args) {
        RandomizedSet t = new RandomizedSet();
        assertTrue(t.insert(1));
        assertFalse(t.remove(2));
        assertTrue(t.insert(2));
        assertEquals(2, t.getRandom());
        assertTrue(t.remove(1));
        assertFalse(t.insert(2));
        assertEquals(2, t.getRandom());
    }

    /**
     * 用dict保存val和list的idx，delete时候交换list的last idx和当前idx，再删除last idx<br>
     * 可实现O(1)的remove
     */
    private final Map<Integer, Integer> dict;
    /**
     * 用list可实现O(1)的insert和getRandom
     */
    private final List<Integer> list;

    private final Random rand = new Random();

    public RandomizedSet() {
        dict = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified
     * element.
     */
    public boolean insert(int val) {
        if (dict.containsKey(val)) return false;

        dict.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!dict.containsKey(val)) return false;

        // move the last element to the place idx of the element to delete
        int lastElement = list.get(list.size() - 1);
        int idx = dict.get(val);
        list.set(idx, lastElement);
        dict.put(lastElement, idx);
        // delete the last element
        list.remove(list.size() - 1);
        dict.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
