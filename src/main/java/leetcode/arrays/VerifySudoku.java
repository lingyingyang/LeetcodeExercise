package leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class VerifySudoku {
    public static void main(String[] args) {
        char[][] in = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        VerifySudoku t = new VerifySudoku();
        boolean out = t.isValidSudoku(in);
        System.out.println(out);
    }

    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char currVal = board[row][col];
                if (currVal == '.') continue;
                // 用HashSet来判断3种条件是否符合
                if (!set.add(currVal + " in row " + row)
                        || !set.add(currVal + " in column " + col)
                        || !set.add(currVal + " in block " + row / 3 + "," + col / 3)) return false;
            }
        }
        return true;
    }
}
