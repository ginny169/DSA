package org.example.java324.graph.bfs;

import java.util.*;

public class CheapestFlight {
    public static void main(String[] args) {
        int n = 5;
        int[][] flights = {
                {0, 1, 5},
                {1, 2, 5},
                {0, 3, 2},
                {3, 1, 2},
                {1, 4, 1},
                {4, 2, 1}
        };
        int src = 0, dst = 2, k = 2;

        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        /* chuyển về dạng đồ thị
            0: [ [1, 100], [2, 300] ],
            1: [ [2, 200] ]
         */

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]}); //to and price
        }

        int[] visitedCost = new int[n];
        for (int i = 0; i < n; i++) {
            visitedCost[i] = 100000;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, src, 0}); // cost, des, stops
        visitedCost[src] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();

            if (cur[2] > k) {
                continue;
            }

            if (cur[2] <= k) {
                List<int[]> nexts = graph.getOrDefault(cur[1], new ArrayList<>());
                for (int[] next : nexts) {
                    int nextCity = next[0];
                    int nextCost = next[1] + cur[0];
                    if (nextCost < visitedCost[nextCity]) {
                        queue.add(new int[]{nextCost, nextCity, cur[2] + 1});
                        visitedCost[nextCity] = nextCost;
                    }
                }
            }

        }
        if (visitedCost[dst] != 100000) {
            return visitedCost[dst];
        }
        return -1;
    }
}
