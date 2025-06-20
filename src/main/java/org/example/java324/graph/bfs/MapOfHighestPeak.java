package org.example.java324.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {

    public static void main(String[] args) {
        int[][] grid = {
                //[1,0,1],[0,0,0],[1,0,1]
                {1, 0, 0},
                {0, 0, 0},
                {1, 0, 0}

                //
                // 0, 1, 2
                // 1, 2, 3
                // 0, 1, 2
        };
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] result = highestPeak(grid);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
    public static int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;
        Queue<int[]> queue = new LinkedList();
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] used = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[]{i, j, 0});
                    isWater[i][j] = 0;
                    used[i][j]= true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            for (int[] direction : directions) {
                int newRow = cur[0] + direction[0];
                int newCol = cur[1] + direction[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !used[newRow][newCol]) {
                    queue.add(new int[]{newRow, newCol, cur[2] + 1});
                    isWater[newRow][newCol] = cur[2]+1;
                    used[newRow][newCol] = true;
                }
            }

        }
    return isWater;
    }
}
