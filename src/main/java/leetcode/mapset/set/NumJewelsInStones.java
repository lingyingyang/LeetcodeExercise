package leetcode.mapset.set;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumJewelsInStones {
    public static void main(String[] args) {
        int out = new NumJewelsInStones().numJewelsInStones("aA", "aAAbbbb");
        assertEquals(3, out);
    }

    public int numJewelsInStones(String jewels, String stones) {
        if (stones.length() == 0 || jewels.length() == 0) return 0;

        int ans = 0;
        Set<Character> set = new HashSet<>();
        char[] jewelsArr = jewels.toCharArray();
        for (char jewel : jewelsArr) {
            set.add(jewel);
        }
        for (int i = 0; i < stones.length(); i++) {
            char stone = stones.charAt(i);
            if (set.contains(stone)) ans++;
        }
        return ans;
    }
}
