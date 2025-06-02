package org.example.java324.graph;

public class NumberOfEnClaves {

    public static void main(String[] args) {
        int[][] dislikes = {{0, 1, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(numEnclaves(dislikes));
    }

    public static int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int max = 0;
        for (int i = 1; i < rows-1; i++) {
            for (int j = 1; j < cols-1; j++) {
                if (grid[i][j] == 1) {
                    max += dfs(grid, i, j);
                }
            }
        }
        return max;
    }

    public static int dfs(int[][] grid, int row, int col) {
        grid[row][col] = 0;
        int result = 1;
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1) {
            return 0;
        }
        if (row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1) {
            if (grid[row][col] == 1) {
                result = 0;
            }
        }
        if (row < grid.length-1 && grid[row + 1][col] == 1) {
            int res = dfs(grid, row + 1, col);
            if (res > 0) {
                result += res;
            } else {
                return 0;
            }
        }
        if (row > 0 && grid[row - 1][col] == 1) {
            int res = dfs(grid, row - 1, col);
            if (res > 0) {
                result += res;
            } else {
                return 0;
            }
        }
        if (col < grid[0].length - 1 && grid[row][col + 1] == 1) {
            int res = dfs(grid, row, col + 1);
            if (res > 0) {
                result += res;
            } else {
                return 0;
            }
        }
        if (col > 0 && grid[row][col - 1] == 1) {
            int res = dfs(grid, row, col - 1);
            if (res > 0) {
                result += res;
            } else {
                return 0;
            }
        }
        return result;
    }
}
