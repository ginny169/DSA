package org.example.java324.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {
    public static void main(String[] args) {
        int n = 17;
        System.out.println(numSquares(n));
    }

    public static int numSquares(int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(new int[]{0, 0});
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();

            for (int i = 1; i * i <= n; i++) {
                int next = cur[0] + i * i;
                if (next == n) {
                    return cur[1] + 1;
                }
                if (next < n && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, cur[1] + 1});
                }
            }
        }
        return -1;
    }
}
