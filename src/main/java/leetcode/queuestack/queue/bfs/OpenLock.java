package leetcode.queuestack.queue.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class OpenLock {
    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        OpenLock t = new OpenLock();
        int out = t.openLock(deadends, target);
        assertThat(out).isEqualTo(6);
    }

    private static final int[] DIRECTIONS = {1, -1};

    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> seen = new HashSet<>();
        int level = 0; // 用null作为delimiter可以得知这层是否结束了
        int count = 0;

        LinkedList<String> q = new LinkedList<>();
        q.add("0000");
        q.add(null);
        while (!q.isEmpty()) {
            count++;
            String point = q.poll();
            if (point == null) {
                // 层数+1，并且如果q还有的话，加下一层的delimiter
                level++;
                if (q.peek() != null) q.offer(null);
            } else if (point.equals(target)) {
                System.out.println("count: " + count);
                return level;
            } else {
                for (int dimension = 0; dimension < 4; dimension++) {
                    for (int direction : DIRECTIONS) { // 四个维度各2个方向bfs
                        int val = ((point.charAt(dimension) - '0') + direction + 10) % 10; // 使得0-9是一个环
                        String next = point.substring(0, dimension) + val + point.substring(dimension + 1);
                        if (!deads.contains(point) && !seen.contains(next)) {
                            q.offer(next);
                            seen.add(next);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
