package org.example.java324.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(numSquares(n));
    }

    public static int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(0);
        visited[0] = true;

        int result = 0;

        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll(); //lay queue ra de duyet
                for (int j = 1; j*j <=n; j++){
                    int temAmount = cur + j * j;
                    if (temAmount == n) {
                        return result;
                    }
                    if (temAmount < n && !visited[temAmount]) {
                        visited[temAmount] = true;
                        queue.offer(temAmount);
                    }
                }
            }
        }
        return -1;
    }
}
