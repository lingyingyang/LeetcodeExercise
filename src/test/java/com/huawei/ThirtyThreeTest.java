package com.huawei;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThirtyThreeTest {
    @Test
    void name() {
        long in = 154;
        System.out.println(Long.toBinaryString(in));
        assertEquals("10011010", Long.toBinaryString(in));
    }
}