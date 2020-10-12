package leetcode.queuestack.stack.dfs;

import java.util.Arrays;

/**
 * 图像渲染
 */
public class RenderImage {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] out = new RenderImage().floodFill(image, 1, 1, 2);
        System.out.println(Arrays.deepToString(out));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image[0] == null) return null;

        int color = image[sr][sc];
        int rows = image.length;
        int cols = image[0].length;
        boolean[][] visited = new boolean[rows][cols];
        helper(image, sr, sc, rows, cols, color, newColor, visited);
        return image;
    }

    private void helper(
            int[][] image,
            int row,
            int col,
            int rows,
            int cols,
            int color,
            int newColor,
            boolean[][] visited) {
        if (row < 0
                || col < 0
                || row >= rows
                || col >= cols
                || visited[row][col]
                || image[row][col] != color) return;

        visited[row][col] = true;
        image[row][col] = newColor;
        helper(image, row - 1, col, rows, cols, color, newColor, visited); // left
        helper(image, row + 1, col, rows, cols, color, newColor, visited); // right
        helper(image, row, col - 1, rows, cols, color, newColor, visited); // up
        helper(image, row, col + 1, rows, cols, color, newColor, visited); // down
    }
}
