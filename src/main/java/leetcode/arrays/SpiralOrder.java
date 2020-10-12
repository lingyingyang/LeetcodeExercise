package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {
        SpiralOrder t = new SpiralOrder();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> out = t.spiralOrder(matrix);
        System.out.println(out.toString());
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) return ans;

        int rowLen = matrix.length, colLen = matrix[0].length;
        boolean[][] seen = new boolean[rowLen][colLen];
        int[] rowDirect = {0, 1, 0, -1};
        int[] colDirect = {1, 0, -1, 0};
        int row = 0, col = 0, direct = 0;
        for (int i = 0; i < rowLen * colLen; i++) { // 遍历所有
            ans.add(matrix[row][col]);
            seen[row][col] = true;
            // 判断下一个row和col
            int nextRow = row + rowDirect[direct];
            int nextCol = col + colDirect[direct];
            if (0 <= nextRow
                    && nextRow < rowLen
                    && 0 <= nextCol
                    && nextCol < colLen
                    && !seen[nextRow][nextCol]) { // 边界条件判断
                row = nextRow;
                col = nextCol;
            } else { // 该顺时针转向
                direct = (direct + 1) % 4;
                row += rowDirect[direct];
                col += colDirect[direct];
            }
        }
        return ans;
    }
}
