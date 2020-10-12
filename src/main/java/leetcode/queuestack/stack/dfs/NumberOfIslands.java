package leetcode.queuestack.stack.dfs;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfIslands {
    public static void main(String[] args) {
        NumberOfIslands t = new NumberOfIslands();
        char[][] in =
                new char[][]{
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '1'},
                        {'0', '0', '0', '0', '1'},
                };
        int ans = t.numIslands(in);
        assertThat(ans).isEqualTo(2);
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++)
                if (grid[row][col] == ISLAND) {
                    //                    dfsHelperRecur(grid, row, col, rows, cols);
                    dfsHelperStack(grid, row, col, rows, cols);
                    ++count;
                }
        }
        return count;
    }

    public static final char ISLAND = '1';
    public static final char SEA = '0';
    private static final int[][] DIRECTIONS =
            new int[][]{{-1, 0} /*left*/, {1, 0} /*right*/, {0, 1} /*up*/, {0, -1} /*down*/};

    private void dfsHelperStack(char[][] grid, int row, int col, int rows, int cols) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});
        while (!stack.isEmpty()) {
            int[] point = stack.pop();
            for (int[] direction : DIRECTIONS) {
                int nextRow = point[0] + direction[0];
                int nextCol = point[1] + direction[1];
                if (nextRow >= 0
                        && nextCol >= 0
                        && nextRow < rows
                        && nextCol < cols
                        && grid[nextRow][nextCol] == ISLAND) {
                    stack.push(new int[]{nextRow, nextCol});
                    grid[nextRow][nextCol] = SEA;
                }
            }
      /*for (char[] chars : grid) {
          System.out.println(Arrays.toString(chars));
      }
      System.out.println("---------------------------");*/
        }
    }

    private void dfsHelperRecur(char[][] grid, int row, int col, int rows, int cols) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] != ISLAND) return;
        grid[row][col] = SEA; // marked it as sea looks like iterated
        dfsHelperRecur(grid, row - 1, col, rows, cols); // left
        dfsHelperRecur(grid, row + 1, col, rows, cols); // right
        dfsHelperRecur(grid, row, col + 1, rows, cols); // up
        dfsHelperRecur(grid, row, col - 1, rows, cols); // down
    }
}
