package org.example.java324.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarfromLand {

    public static void main(String[] args) {
        int[][] grid = {
                //[1,0,1],[0,0,0],[1,0,1]
                {1, 0, 0},
                {0, 0, 0},
                {1, 0, 0}
        };
        System.out.println(maxDistance(grid));
    }
    public static int maxDistance(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }

        if (queue.isEmpty() || queue.size() == rows * cols) {
            return -1;
        }

        int result = -1;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] cur = queue.remove();
                for (int[] x : directions){
                    int newRow = x[0] + cur[0];
                    int newCol = x[1] + cur[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 0) {
                        grid[newRow][newCol] = 1;
                        queue.offer(new int[]{newRow, newCol, cur[2]+1});
                        result = Math.max(cur[2]+1, result);
                    }
                }
            }
        }
        return result;
    }
}
