package org.example.java324.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];

        queue.offer(0);
        visited[0] = true;

        int result = 0;

        while (!queue.isEmpty()) {
            result++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int cur = queue.poll(); //lay queue ra de duyet
                for (int coin : coins) {
                    int temAmount = cur + coin;
                    if (temAmount == amount) {
                        return result;
                    }
                    if (temAmount < amount && !visited[temAmount]) {
                        visited[temAmount] = true;
                        queue.offer(temAmount);
                    }
                }
            }
        }
        return -1;
    }
}
