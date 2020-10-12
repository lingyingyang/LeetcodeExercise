package leetcode.dp;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (row == 0 && col != 0) { // first row
                    grid[row][col] = grid[row][col] + grid[row][col - 1];
                } else if (row != 0 && col == 0) { // first col
                    grid[row][col] = grid[row][col] + grid[row - 1][col];
                } else if (row == 0 && col == 0) { // start point
                    grid[row][col] = grid[row][col];
                } else {
                    grid[row][col] = Math.min(grid[row][col - 1], grid[row - 1][col]) + grid[row][col];
                }
            }
        }

        return grid[rowLength - 1][colLength - 1];
    }
}
