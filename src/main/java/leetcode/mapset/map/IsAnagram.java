package leetcode.mapset.map;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class IsAnagram {
    public static void main(String[] args) {
        String t = "good";
        String s = "dogo";
        boolean out = new IsAnagram().isAnagram(s, t);
        assertThat(out).isTrue();
    }

    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }
}
