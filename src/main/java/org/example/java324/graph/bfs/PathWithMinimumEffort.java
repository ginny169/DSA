package org.example.java324.graph.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int[][] grid = {
                //[1,0,1],[0,0,0],[1,0,1]
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        System.out.println(minimumEffortPath(grid));
    }

    public static int minimumEffortPath(int[][] heights) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] effort = new int[rows][cols];
        for (int[] row : effort)
            Arrays.fill(row, Integer.MAX_VALUE);
        effort[0][0] = 0;

        queue.add(new int[]{0, 0, 0}); //[2] la effort

        int result = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int curEffort = cur[2];

            if (cur[0] == rows -1 && cur[1] == cols -1){
                return curEffort;
            }
            for (int[] x : directions) {
                int newRow = x[0] + cur[0];
                int newCol = x[1] + cur[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    int nextEffort = Math.max(curEffort, Math.abs(heights[newRow][newCol] - heights[cur[0]][cur[1]]));

                    if (nextEffort < effort[newRow][newCol]) {
                        effort[newRow][newCol] = nextEffort;
                        queue.offer(new int[]{newRow, newCol, nextEffort});
                    }                    result = Math.max(heights[newRow][newCol] - cur[2], result);
                }
            }
        }
        return 0;
    }
}
