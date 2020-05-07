package leetcode.queuestack.queue.bfs;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfIslands {
    public static void main(String[] args) {
        NumberOfIslands t = new NumberOfIslands();
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        int out = t.numIslands(grid);
        assertThat(out).isEqualTo(1);
    }

    private static final char ISLAND = '1';
    private static final char SEA = '0';
    private static final int[][] DIRECTIONS = new int[][]{
            {-1, 0}/*left*/, {1, 0}/*right*/, {0, 1}/*up*/, {0, -1}/*down*/};

    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid.length == 0) return count;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == SEA) continue;
                //遇到island
                bfsHelper(grid, row, col, rows, cols);
                count++;
            }
        }
        return count;
    }

    private void bfsHelper(char[][] grid, int row, int col, int rows, int cols) {
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0];
            int c = point[1];
            for (int[] direction : DIRECTIONS) {
                int rowNext = r + direction[0];
                int colNext = c + direction[1];
                if (rowNext < 0 || colNext < 0 || rowNext >= rows || colNext >= cols || grid[rowNext][colNext] != ISLAND)
                    continue;
                grid[rowNext][colNext] = SEA;
                q.add(new int[]{rowNext, colNext});
            }
        }
    }
}
