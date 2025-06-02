package org.example.java324.graph;

public class NumberOfEnClaves {

    public static void main(String[] args) {
        int[][] dislikes = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(numEnclaves(dislikes));
    }

    private static int[] rx = new int[]{1, -1, 0, 0};
    private static int[] ry = new int[]{0, 0, -1, 1};

    public static int numEnclaves(int[][] grid) {
        int s = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0, n, m, grid);
            }
            if (grid[i][m - 1] == 1) {
                dfs(i, m - 1, n, m, grid);
            }
        }
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1) {
                dfs(0, i, n, m, grid);
            }
            if (grid[n - 1][i] == 1) {
                dfs(n - 1, i, n, m, grid);
            }
        }
        for(int i=1;i<n-1;i++) {
            for(int j=1;j<m-1;j++) {
                if(grid[i][j] == 1) {
                    s++;
                }
            }
        }
        return s;
    }

    private static void dfs(int x, int y, int n, int m, int[][] grid) {
        grid[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int newX = x + rx[i];
            int newY = y + ry[i];
            if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1) {
                dfs(newX, newY, n, m, grid);
            }
        }
    }
}
