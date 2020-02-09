package recurrsion;

public class NumberOfIslands {
    private int rowLength;
    private int colLength;

    public int numIslands(char[][] grid) {
        int count = 0;
        rowLength = grid.length;
        if (rowLength == 0) return 0;
        colLength = grid[0].length;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++)
                if (grid[row][col] == '1') {
                    DFSHelper(grid, row, col);
                    ++count;
                }
        }
        return count;
    }

    private void DFSHelper(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= rowLength || col >= colLength || grid[row][col] != '1') return;
        grid[row][col] = '0';
        DFSHelper(grid, row - 1, col); // left
        DFSHelper(grid, row + 1, col); // right
        DFSHelper(grid, row, col + 1); // up
        DFSHelper(grid, row, col - 1); // down
    }
}
