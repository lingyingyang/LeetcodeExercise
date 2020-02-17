package binarysearch;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SearchInRotatedSortedArrayTest {
    @Test
    void whenTest_thenOk() {
        SearchInRotatedSortedArray test = new SearchInRotatedSortedArray();
        int[] in = new int[]{4, 5, 6, 7, 0, 1, 2};
        int actualOut = test.search(in, 0);
        assertEquals(4, actualOut);
    }
}