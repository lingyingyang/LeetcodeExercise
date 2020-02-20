package binarysearch;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

import static binarysearch.CourseSchedule.state.*;

/**
 * https://leetcode.com/problems/course-schedule/
 * if node v has not been visited, then mark it as 0.
 * if node v is being visited, then mark it as -1. If we find a vertex marked as -1 in DFS, then their is a ring.
 * if node v has been visited, then mark it as 1. If a vertex was marked as 1, then no ring contains v or its successors.
 */
@Slf4j
public class CourseSchedule {
    enum state {
        NOT_VISIT,
        VISITING,
        VISITED
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList();

        state[] visit = new state[numCourses];
        Arrays.fill(visit, NOT_VISIT);
        log.info("visit[]: {}", Arrays.toString(visit));
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        log.info("graph: {}", Arrays.toString(graph));

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visit, i)) {
                log.info("visit[]: {}", Arrays.toString(visit));
                return false;
            }
        }
        log.info("visit[]: {}", Arrays.toString(visit));
        return true;
    }

    private boolean dfs(ArrayList[] graph, state[] visit, int currCourse) {
        if (visit[currCourse] == VISITING)
            return false;
        else if (visit[currCourse] == VISITED)
            return true;

        visit[currCourse] = VISITING;
        for (int i = 0; i < graph[currCourse].size(); i++) {
            if (!dfs(graph, visit, (int) graph[currCourse].get(i)))
                return false;
        }
        visit[currCourse] = VISITED;
        return true;
    }
}
