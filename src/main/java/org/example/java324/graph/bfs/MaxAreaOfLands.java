package org.example.java324.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfLands {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 0, 1, 1}
        };
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int max = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(bfs(grid, i, j, visited), max);
                }
            }
        }
        return max;
    }

    public static int bfs(int[][] grid, int startRow, int startCol, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                        grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    result++;
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
        return result;
    }
}
