package org.example.java324.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args){
        int[][] grid = {{0, 1, 2, 0}, {0, 0, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
            /*0 representing an empty cell,
              1 representing a fresh orange, or
              2 representing a rotten orange.*/
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }

        int max = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            for (int[] x : directions) {
                int newRow = x[0] + cur[0];
                int newCol = x[1] + cur[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1){
                    queue.add(new int[]{newRow,newCol,cur[2] + 1});
                    grid[newRow][newCol] = 2;
                }
            }
            max = Math.max(cur[2],max);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return max;
    }
}

