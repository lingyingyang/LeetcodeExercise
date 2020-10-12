package com.aws;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        String s1 = "f3";
        String s2 = "t2";
        List<String> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.sort(Comparator.comparing(s -> s));
        System.out.println(list.toString());
        //        System.out.println(s1.compareTo(s2));

        //        Solution2 t = new Solution2();
        //        List<String> logLines = Arrays.asList("a1 aaa ss", "mi2 dd bb cc", "wz3 11 22", "x4 55
        // 66");
        //        List<String> out = t.reorderLines(4, logLines);
        //        System.out.println(out.toString());
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> reorderLines(int logFileSize, List<String> logLines) {
        List<String[]> words = new ArrayList<>();
        List<String[]> numbers = new ArrayList<>();
        for (String logLine : logLines) {
            int identifier = logLine.indexOf(' ');
            String remaining = logLine.substring(identifier + 1);
            String[] item = new String[]{logLine.substring(0, identifier), remaining};
            if (Character.isDigit(remaining.charAt(0))) {
                numbers.add(item);
            } else {
                words.add(item);
            }
        }

        List<String> ans = new ArrayList<>();
        words.sort(Comparator.comparing(o -> o[1]));
        numbers.sort(Comparator.comparing(o -> o[1]));

        for (String[] word : words) {
            ans.add(word[0] + " " + word[1]);
        }
        for (String[] number : numbers) {
            ans.add(number[0] + " " + number[1]);
        }
        return ans;
    }
    // METHOD SIGNATURE ENDS
}
