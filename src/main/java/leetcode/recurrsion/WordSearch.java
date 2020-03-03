package leetcode.recurrsion;

/**
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {
    private int rowLength;
    private int colLength;

    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        rowLength = board.length;
        colLength = board[0].length;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (helper(board, row, col, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int row, int col, char[] word, int i) {
        if (row < 0 || col < 0 || row >= rowLength || col >= colLength) return false;
        if (i == word.length) return true;
        if (board[row][col] != word[i]) return false;

        return helper(board, row, col + 1, word, i + 1) // right
                || helper(board, row, col - 1, word, i + 1) // left
                || helper(board, row + 1, col, word, i + 1) // up
                || helper(board, row - 1, col, word, i + 1); // down
    }
}
