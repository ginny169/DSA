package org.example.java324.graph;

import java.util.ArrayList;
import java.util.List;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,1,1,0,0},
                {0,0,1,0,0,0,1,1,0,0},
                {0,0,0,0,0,0,1,1,0,0},
                {1,1,0,0,1,1,1,0,0,0},
                {1,1,0,0,1,1,0,0,0,0}
        };

        System.out.println(maxAreaOfIsland(grid));
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        boolean[][] used = new boolean[rows][cols];
        for (int i = 0; i< rows; i++){
            for (int j = 0; j< cols; j++){
                if (grid[i][j]==1 && !used[i][j]){
                    int result = dfs(grid,i,j,used);
                    maxArea = Math.max(result,maxArea);
                }
            }
        }
        return maxArea;
    }

    public static int dfs(int[][] grid, int i, int j, boolean[][] used) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length||grid[i][j]==0||used[i][j]) {
            return 0;
        }
        used[i][j] = true;
        int result = 1;
        result += dfs(grid, i + 1, j, used);
        result += dfs(grid, i - 1, j, used);
        result += dfs(grid, i, j+1, used);
        result += dfs(grid, i, j-1, used);

        return result;
    }
}
