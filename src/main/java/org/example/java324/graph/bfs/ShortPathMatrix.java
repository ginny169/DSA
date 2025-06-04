package org.example.java324.graph.bfs;

import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.Queue;

public class ShortPathMatrix {

    public static void main(String[] args){
        int[][] grid = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 1, 0, 0}, {0, 1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }

        int[] start = {0, 0, 1};
        queue.offer(start);
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            if (cur[0]==grid.length-1 && cur[1]== grid[0].length-1){
                return cur[2];
            }
            for (int[] x : directions) {
                int[] next = {x[0] + cur[0], x[1] + cur[1], cur[2] + 1};
                if (x[0] + cur[0] >= 0 && x[0] + cur[0] < grid.length && x[1] + cur[1] >= 0 && x[1] + cur[1] < grid[0].length && grid[next[0]][next[1]] == 0) {
                    queue.add(next);
                    grid[next[0]][next[1]] = 1;
                }
            }
        }
        return -1;
    }
    //       int[][] grid = {{0, 1, 2, 0},
    //                      { 0, 0, 1, 0},
    //                       {0, 1, 1, 0},
    //                       {0, 1, 1, 0}};
}
