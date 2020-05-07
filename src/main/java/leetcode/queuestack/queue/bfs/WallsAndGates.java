package leetcode.queuestack.queue.bfs;

import java.util.Arrays;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class WallsAndGates {
    public static void main(String[] args) {
        WallsAndGates t = new WallsAndGates();
        int[][] rooms = new int[][]{
                {EMPTY, BLOCK, GATE, EMPTY},
                {EMPTY, EMPTY, EMPTY, BLOCK},
                {EMPTY, BLOCK, EMPTY, BLOCK},
                {GATE, BLOCK, EMPTY, EMPTY}
        };
        t.wallsAndGates(rooms);
        String out = Arrays.deepToString(rooms);
        System.out.println(out);
        assertThat(out).isEqualTo("[[3, -1, 0, 1], [2, 2, 1, -1], [1, -1, 2, -1], [0, -1, 3, 4]]");
    }

    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int BLOCK = -1;
    private static final int[][] DIRECTIONS = new int[][]{
            {-1, 0}/*left*/, {1, 0}/*right*/, {0, 1}/*up*/, {0, -1}/*down*/};

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) return;
        LinkedList<int[]> q = new LinkedList<>();

        //所有门入队
        int rows = rooms.length;
        int cols = rooms[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (rooms[row][col] == GATE) {
                    q.add(new int[]{row, col});
                }
            }
        }

        //bfs门到房间的距离，访问过的不再访问
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            //bfs四个方向
            for (int[] direction : DIRECTIONS) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                //非空房间，跳过
                if (nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= cols || rooms[nextRow][nextCol] != EMPTY)
                    continue;
                //房间与当前point的距离+1，然后放进队列中，进行下一次的bfs
                rooms[nextRow][nextCol] = rooms[row][col] + 1;
                q.add(new int[]{nextRow, nextCol});
            }
        }
    }
}
