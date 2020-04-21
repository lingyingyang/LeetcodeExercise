package leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfNiceSubArraysTest {
    @Test
    void test() {
        assertEquals(0, 2 & 1);
        assertEquals(1, 3 & 1);
        assertEquals(1, 11 & 1);
        assertEquals(0, 12 & 1);
    }
}