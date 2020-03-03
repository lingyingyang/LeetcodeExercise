package leetcode.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseScheduleTest {
    @Test
    void whenTest_thenOk() {
        CourseSchedule test = new CourseSchedule();
        int[][] in = new int[][]{{1, 0}, {2, 1}};
        boolean out = test.canFinish(3, in);
        assertTrue(out);

        int[][] in1 = new int[][]{{1, 0}, {0, 1}};
        out = test.canFinish(3, in1);
        assertFalse(out);
    }
}