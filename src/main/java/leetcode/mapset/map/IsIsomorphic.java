package leetcode.mapset.map;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class IsIsomorphic {
    public static void main(String[] args) {
        IsIsomorphic test = new IsIsomorphic();
        String s = "egg";
        String t = "boo";
        boolean out = test.isIsomorphic(s, t);
        assertThat(out).isTrue();

        String s1 = "ab";
        String s2 = "aa";
        boolean out1 = test.isIsomorphic(s1, s2);
        assertThat(out1).isFalse();
    }

    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    public boolean isIsomorphicHelper(String s, String t) {
        //map存储s与t的字符替换映射
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                char c = map.get(c1);
                if (c2 != c) return false;
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }
}
