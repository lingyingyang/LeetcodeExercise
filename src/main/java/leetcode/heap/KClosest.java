package leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosest {
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        KClosest t = new KClosest();
        int[][] out = t.kClosest(points, k);
        System.out.println(Arrays.deepToString(out));
    }

    /**
     * 时间复杂度：O(N log N)，其中 N 是给定点的数量。 空间复杂度：O(N)。
     *
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest(int[][] points, int k) {
        DistanceComparator comparator = new DistanceComparator();

        PriorityQueue<Integer[]> heap = new PriorityQueue<>(10, comparator);
        for (int i = 0; i < points.length; i++) {
            Integer[] point = new Integer[]{points[i][0], points[i][1]};
            if (i < k) {
                heap.offer(point);
            }
            // 如果当前point大于队列中的第一个，则其优先级小于队列中的最高优先级
            else if (comparator.compare(point, heap.peek()) > 0) {
                heap.offer(point);
                heap.poll();
            }
        }

        int[][] out = new int[k][2];
        for (int i = 0; i < k; i++) {
            Integer[] point = heap.poll();
            out[i][0] = point[0];
            out[i][1] = point[1];
        }
        return out;
    }

    private static class DistanceComparator implements Comparator<Integer[]> {
        @Override
        public int compare(Integer[] a, Integer[] b) {
            return Double.compare(
                    Math.pow(b[0], 2) + Math.pow(b[1], 2), Math.pow(a[0], 2) + Math.pow(a[1], 2));
        }
    }
}
