package org.example.java324.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueenPrint {

    public static void main(String[] args) {
        int n = 4;
//        List<List<String>> result = solveNQueens(n);
        System.out.println(solveNQueens(n));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        backtrack(n, 0, new boolean[n + 1], new boolean[n * 2 + 1], new boolean[n * 2 + 1], new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int n, int index, boolean[] columm, boolean[] diagonal1, boolean[] diagonal2, List<Integer> path, List<List<String>> result) {
        //hoán vị và đường chéo
        //diagonal1 là dường chéo phải.
        //diagonal2 là đường chéo trai.
        // 1 2 3 4 ==>  12 23 34 diagonal1
        // 1 2 3 4 ==>  14 23 32 41
        // 1 2 3 4
        // 1 2 3 4
        //[[".Q..", "...Q", "Q...", "..Q."],["..Q.", "Q...", "...Q", ".Q.."]]
        if (index == n) {
            result.add(convertIntToString(path,n));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!columm[i] && !diagonal1[i - index + n] && !diagonal2[i + index]) {
                columm[i] = true;
                diagonal1[i - index + n] = true;
                diagonal2[i + index] = true;
                path.add(i);
                backtrack(n, index + 1, columm, diagonal1, diagonal2, path, result);
                columm[i] = false;
                diagonal1[i - index + n] = false;
                diagonal2[i + index] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    // 2, 4, 1, 3 --> .Q..,...Q
    public static List<String> convertIntToString(List<Integer> e, int n) {
        List<String> result = new ArrayList<>();
        for (int value : e) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == value - 1) {
                    res.append("Q");
                } else {
                    res.append(".");
                }
            }
            result.add(res.toString());
        }
        return result;
    }
}
