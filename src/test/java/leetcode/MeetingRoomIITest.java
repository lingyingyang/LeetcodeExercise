package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MeetingRoomIITest {
    @Test
    void test() {
        MeetingRoomII test = new MeetingRoomII();
        int[][] in = {{0, 30}, {5, 10}, {15, 20}};
        int out = test.minMeetingRooms(in);
        assertThat(out).isEqualTo(2);
    }
}