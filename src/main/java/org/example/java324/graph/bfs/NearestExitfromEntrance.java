package org.example.java324.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitfromEntrance {
    public static void main(String[] args) {
        char[][] maze = {
                {'+', '+', '+'},
                {'.', '.', '.'},
                {'+', '+', '+'}
        };
        int[] entrance = {1, 2}; // Entrance at row 1, column 2

        int result = nearestExit(maze, entrance);
        System.out.println(result);
    }
    public static int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;

        Queue<int[]> queue = new LinkedList();
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        queue.add(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]]= '+';

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            for (int[] direction : directions) {
                int newRow = cur[0] + direction[0];
                int newCol = cur[1] + direction[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && maze[newRow][newCol] == '.') {
                    if (newRow == 0 || newRow == rows-1 ||newCol == 0 || newCol == cols - 1){
                        return cur[2] + 1;
                    }
                    maze[newRow][newCol] = '+';
                    queue.add(new int[]{newRow, newCol, cur[2] + 1});

                }
            }
        }
        return -1;
    }

}
