package leetcode.mapset.map;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstUniqChar {
    public static void main(String[] args) {
        String s = "loveleetcode";
        int out = new FirstUniqChar().firstUniqChar(s);
        assertThat(out).isEqualTo(2);
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (countMap.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
