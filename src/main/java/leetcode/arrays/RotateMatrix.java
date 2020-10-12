package leetcode.arrays;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        RotateMatrix t = new RotateMatrix();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        t.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 时间复杂度：O(N^2)<br>
     * 空间复杂度：O(1) 由于旋转操作是 就地 完成的。
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix 转置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}
