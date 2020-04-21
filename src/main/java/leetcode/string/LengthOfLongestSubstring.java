package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring t = new LengthOfLongestSubstring();
//        System.out.println(t.lengthOfLongestSubstring("abcabcbb"));//3
        System.out.println(t.lengthOfLongestSubstring("abcba"));//3

    }

    public int lengthOfLongestSubstring(String s) {
        int ans = 0, len = s.length();
        //记录每个char离fast最近的idx
        Map<Character, Integer> map = new HashMap<>();
        for (int fast = 0, slow = 0; fast < len; fast++) {
            if (map.containsKey(s.charAt(fast))) {//遇到重复的值
                //跳过重复的窗口，slow取最大的值,即浮动窗口不包括之前的重复值
                slow = Math.max(map.get(s.charAt(fast)) + 1, slow);
            }
            map.put(s.charAt(fast), fast);
            ans = Math.max(ans, fast - slow + 1);//取得最大值
            System.out.println(map.toString());
        }

        return ans;
    }
}
