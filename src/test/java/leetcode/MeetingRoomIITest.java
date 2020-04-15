package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MeetingRoomIITest {
    @Test
    void test() {
        MeetingRoomII test = new MeetingRoomII();
        int[][] in = {{0, 30}, {5, 10}, {15, 20}};
        int out = test.minMeetingRooms(in);
        assertEquals(2, out);
    }
}