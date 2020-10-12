package leetcode.queuestack.queue.bfs;

import java.util.Arrays;
import java.util.LinkedList;

public class UpdateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {
                        0, 0, 0,
                },
                {0, 1, 0},
                {1, 1, 1}
        };
        int[][] out = new UpdateMatrix().updateMatrix(matrix);
        for (int[] row : out) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static final int[][] DIRECTIONS =
            new int[][]{{-1, 0} /*left*/, {1, 0} /*right*/, {0, 1} /*up*/, {0, -1} /*down*/};

    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return new int[][]{};
        int cols = matrix[0].length;
        boolean[][] seen = new boolean[rows][cols];
        for (boolean[] row : seen) {
            Arrays.fill(row, false);
        }
        LinkedList<int[]> q = new LinkedList<>();

        // 将所有的 0 添加进初始队列中
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    q.offer(new int[]{row, col});
                    seen[row][col] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) { // bfs四个方向
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                // 遇到seen，跳过
                if (nextRow < 0
                        || nextCol < 0
                        || nextRow >= rows
                        || nextCol >= cols
                        || seen[nextRow][nextCol]) continue;
                //                System.out.printf("current: [%s, %s], next: [%s, %s] = %s\n",
                //                        row, col, nextRow, nextCol, matrix[nextRow][nextCol]);
                seen[nextRow][nextCol] = true;
                matrix[nextRow][nextCol] = matrix[row][col] + 1;
                q.offer(new int[]{nextRow, nextCol});
            }
        }

        return matrix;
    }
}
