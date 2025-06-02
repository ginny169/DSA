package org.example.java324.graph;

import java.util.ArrayList;
import java.util.List;

public class PossibleBipartition {

    public static void main(String[] args) {
        int[][] dislikes = {{1, 2}, {2, 3}, {3, 4}};
        int n = 4;
        System.out.println(possibleBipartition(n, dislikes));
    }

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> danhsachKe = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            danhsachKe.add(new ArrayList<>());
        }
        for (int i = 0; i < dislikes.length; i++) {
            danhsachKe.get(dislikes[i][0]).add(dislikes[i][1]);
            danhsachKe.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        int[] used = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                if (!dfs(n, i, danhsachKe, used)) {
                    return false;
                }
            }
        }
        return true;
    }
    // 0, { 2, 3, 4}
    // 1, { 2, 3}

    public static boolean dfs(int n, int current, List<List<Integer>> danhsachKe, int[] used) {

        for (int i = 0; i < danhsachKe.get(current).size(); i++) {

            if (used[current] == used[danhsachKe.get(current).get(i)]) {
                return false;
            }

            if (used[danhsachKe.get(current).get(i)] == 0) {
                used[danhsachKe.get(current).get(i)] = 3 - used[current];
                if (!dfs(n, danhsachKe.get(current).get(i), danhsachKe, used)) {
                    return false;
                }
            }
        }
        return true;
    }
}
