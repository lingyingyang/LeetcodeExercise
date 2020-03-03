package leetcode.recurrsion;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class WordSearchTest {
    @Test
    void whenTest_thenOk() {
        WordSearch test = new WordSearch();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String in = "SEE";
        boolean out = test.exist(board, in);
        assertTrue(out);
        char[][] board1 = new char[][]{{'a', 'a'}};
        String in1 = "aaa";
        boolean out1 = test.exist(board1, in1);
        assertFalse(out1);
    }

    @Test
    void test() {
        char c = 'x';
        c ^= 256;
        log.info(String.valueOf(c));
    }
}