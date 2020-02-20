package recurrsion;

public class NumberOfIslands {
    public static final char ISLAND = '1';
    public static final char SEA = '0';

    private int rowLength;
    private int colLength;

    public int numIslands(char[][] grid) {
        int count = 0;
        rowLength = grid.length;
        if (rowLength == 0) return 0;
        colLength = grid[0].length;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++)
                if (grid[row][col] == ISLAND) {
                    DFSHelper(grid, row, col);
                    ++count;
                }
        }
        return count;
    }

    private void DFSHelper(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= rowLength || col >= colLength || grid[row][col] != ISLAND) return;
        grid[row][col] = SEA; // marked it as sea looks like iterated
        DFSHelper(grid, row - 1, col); // left
        DFSHelper(grid, row + 1, col); // right
        DFSHelper(grid, row, col + 1); // up
        DFSHelper(grid, row, col - 1); // down
    }
}
