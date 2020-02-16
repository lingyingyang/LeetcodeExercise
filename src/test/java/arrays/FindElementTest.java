package arrays;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class FindElementTest {
    @Test
    void whenTest_thenOk() {
        FindElement test = new FindElement();
        int[] in = new int[]{5, 7, 7, 8, 8, 10};
        int[] actualOut = test.searchRange(in, 8);
        log.info("result: {}", actualOut);
        assertEquals("[3, 4]", Arrays.toString(actualOut));
    }
}