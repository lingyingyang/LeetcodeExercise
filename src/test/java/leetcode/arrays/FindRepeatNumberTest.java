package leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindRepeatNumberTest {
    @Test
    void test() {
        FindRepeatNumber test = new FindRepeatNumber();
        int[] in = {2, 3, 1, 0, 2, 5, 3};
        int out = test.findRepeatNumber(in);
        assertEquals(3, out);
    }
}