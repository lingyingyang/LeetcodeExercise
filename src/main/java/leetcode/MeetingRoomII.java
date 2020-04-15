package leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/meeting-rooms-ii/solution/hui-yi-shi-ii-by-leetcode/
 * 最小堆，优先队列
 */
@Slf4j
public class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // Min heap
        PriorityQueue<Integer> allocator = new PriorityQueue<>(
                intervals.length,
                Comparator.comparingInt(a -> a));

        // 按照 开始时间 对会议进行排序。
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // 初始化一个新的 最小堆，将第一个会议的结束时间加入到堆中。
        // 我们只需要记录会议的结束时间，告诉我们什么时候房间会空。
        allocator.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            log.info("[before] begin time: {}, allocator: {}", intervals[i][0], allocator.toString());
            // 对每个会议，检查堆的最小元素（即堆顶部的房间）是否空闲
            // 若房间空闲，则从堆顶拿出该元素，将其改为我们处理的会议的结束时间，加回到堆中。
            // 若房间不空闲。开新房间，并加入到堆中。
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
            log.info("[after] end time: {}, allocator: {}", intervals[i][1], allocator.toString());
        }

        // 处理完所有会议后，堆的大小即为开的房间数量。这就是容纳这些会议需要的最小房间数。
        return allocator.size();
    }
}
