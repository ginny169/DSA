package org.example.java324.graph.bfs;

import java.util.*;

public class MinimumPathScoreBetweenCities {
    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {
                {1, 2, 9},
                {2, 3, 6},
                {2, 4, 5},
                {1, 4, 7}
        };

        int result = minScore(n, roads);
        System.out.println(result);
    }

    public static int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] road : roads) {
            graph.putIfAbsent(road[0], new ArrayList<>());
            graph.putIfAbsent(road[1], new ArrayList<>());
            graph.get(road[0]).add(new int[]{road[1], road[2]});
            graph.get(road[1]).add(new int[]{road[0], road[2]});
        }

        int[] vistedScore = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            vistedScore[i] = 100000;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 100000}); //city , score

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            List<int[]> nexts = graph.getOrDefault(cur[0], new ArrayList<>());
            for (int[] next : nexts) {
                int nextCity = next[0];
                int nextScore = Math.min(cur[1], next[1]);
                if (vistedScore[nextCity] > nextScore) {
                    queue.add(new int[]{nextCity, Math.min(cur[1], nextScore)});
                    vistedScore[nextCity] = Math.min(cur[1], nextScore);
                }
            }
        }
    return vistedScore[n];
    }
}
