package leetcode.queuestack.stack.dfs;

import java.util.List;

public class KeyAndRoom {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.size() == 0) return false;

        boolean[] visited = new boolean[rooms.size()];
        int room = 0;
        helper(rooms, room, visited);
        for (boolean canVisit : visited) {
            if (!canVisit) return false;
        }
        return true;
    }

    private void helper(List<List<Integer>> rooms, int room, boolean[] visited) {
        if (visited[room]) return;

        visited[room] = true;
        List<Integer> keys = rooms.get(room);
        for (Integer key : keys) {
            helper(rooms, key, visited);
        }
    }
}
