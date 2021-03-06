package leetcode.recurrsion;

import leetcode.queuestack.stack.dfs.NumberOfIslands;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfIslandsTest {
    @Test
    void whenResult_thenOk() {
        NumberOfIslands test = new NumberOfIslands();
        char[][] in = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        int ans = test.numIslands(in);
        assertEquals(1, ans);
    }
}