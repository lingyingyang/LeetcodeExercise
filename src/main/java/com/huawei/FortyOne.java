package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 迷宫问题
 */
public class FortyOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {
            String[] rowAndColumn = str.split(" ");

            int rowSize = Integer.parseInt(rowAndColumn[0]); // 行
            int colSize = Integer.parseInt(rowAndColumn[1]); // 列
            if (rowSize >= 2 && rowSize <= 10 && colSize >= 2 && colSize <= 10) {
                int[][] matrix = new int[rowSize][colSize];
                int row = 0;
                while (row < rowSize) {
                    str = br.readLine();
                    String[] inputs = str.split(" ");
                    if (inputs.length == colSize) {
                        for (int i = 0; i < colSize; i++) {
                            matrix[row][i] = Integer.parseInt(inputs[i]);
                        }
                    }
                    row++;
                }
                findShortestPath(matrix);
            }
        }
    }

    public static void findShortestPath(int[][] maza) {
        // 不考虑多解情况，迷宫只有一条通道
        // 可以横着走或者竖着走
        int i = 0;
        int j = 0;
        while (i < maza.length) {
            while (j < maza[0].length) {
                if (maza[i][j] == 0) {
                    printPath(i, j);
                    j++; // 右
                } else { // 下
                    j--;
                    i++;
                }
            }
            i++;
            if (j == maza[0].length) j--; // 下
        }
    }

    public static void printPath(int i, int j) {
        System.out.println(String.format("(%d,%d)", i, j));
    }
}
