package leetcode.array;

import java.util.Arrays;

public class FindMinArrowShots452 {

    static public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (e1, e2) -> {
            return Integer.compare(e1[1], e2[1]);
        });

        int pos = points[0][1];
        int count = 1;

        for (int[] x : points) {
            if (x[0] > pos) {
                pos = x[1];
                count++;
            }
        }

        return count;
    }
}
