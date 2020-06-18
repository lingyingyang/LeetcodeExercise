package com.google.interview;

public class SearchMatrix {
    public static void main(String[] args) {
        SearchMatrix t = new SearchMatrix();
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(t.searchMatrix(matrix, 5));
        int[][] matrix1 = {{1, 1}};
        System.out.println(t.searchMatrix(matrix1, 2));
        int[][] matrix2 = {{-5}};
        System.out.println(t.searchMatrix(matrix2, -5));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int rowIdx = 0;
        int colIdx = colLen - 1;
        int currVal;
        while (rowIdx < rowLen && colIdx >= 0) {
            currVal = matrix[rowIdx][colIdx];
            if (target == currVal) {
                return true;
            } else if (target < currVal) {
                colIdx--;
            } else { // target > currVal
                rowIdx++;
            }
        }
        return false;
    }
}
