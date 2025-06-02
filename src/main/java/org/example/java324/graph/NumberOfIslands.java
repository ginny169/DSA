package org.example.java324.graph;

public class NumberOfIslands {
    public static void main(String[] args){
        char[][] grid = {
                {'1', '1', '0', '0'},
                {'1', '0', '0', '1'},
                {'0', '1', '1', '0'}
        };
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        boolean[][] used = new boolean[rows][cols];
        for (int i = 0; i< rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j]=='1'&& !used[i][j]){
                    dfs(grid, i, j, used);
                    result++;
                }
            }
        }
        return result;
    }
    public static void dfs(char[][] grid, int row, int col, boolean[][] used){
        if (row < 0 || row >= grid.length|| col < 0 || col >= grid[0].length) {
            return;
        }
        if (used[row][col] || grid[row][col] != '1'){
            return;
        }
        used[row][col] = true;
        dfs(grid, row + 1, col, used);
        dfs(grid, row - 1, col, used);
        dfs(grid, row, col +1, used);
        dfs(grid, row, col-1, used);
    }
}
