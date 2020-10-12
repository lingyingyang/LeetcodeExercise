package leetcode.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Merge {
    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] out = new Merge().merge(intervals);
        System.out.println(Arrays.deepToString(out));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;

        Arrays.sort(intervals, Comparator.comparing(item -> item[0]));
        int pointer = 0; // 返回的结果
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] point = intervals[pointer];
            if (interval[0] > point[1]) { // 下一个不重叠的区间
                // 复制当前interval到下一个pointer
                intervals[++pointer] = interval;
            } else { // 重叠的区间
                intervals[pointer][1] = Math.max(point[1], interval[1]);
            }
        }
        return Arrays.copyOfRange(intervals, 0, pointer + 1);
    }
}
