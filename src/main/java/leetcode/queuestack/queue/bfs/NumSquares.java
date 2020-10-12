package leetcode.queuestack.queue.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NumSquares {
    public static void main(String[] args) {
        NumSquares t = new NumSquares();
        int out = t.numSquares(12);
        assertThat(out).isEqualTo(3);
    }

    public int numSquares(int n) {
        int level = 0;
        ArrayList<Integer> numSquares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            numSquares.add(i * i);
        }
        // 用set替代LinkedList可以去重，提升效率
        // 而且每层都是新的set，所以不需要delimiter
        Set<Integer> q = new HashSet<>();
        q.add(n);
        while (!q.isEmpty()) {
            level++;
            Set<Integer> qNext = new HashSet<>();
            for (Integer remainder : q) {
                for (Integer square : numSquares) {
                    if (remainder.equals(square)) { // 余数如果等于其中一个完全平方数，则表示找到了最短层数了
                        return level;
                    } else if (square > remainder) { // 完全平方数大于余数就跳过本次循环
                        break;
                    } else {
                        qNext.add(remainder - square);
                    }
                }
            }
            q = qNext;
        }
        return level;
    }
}
