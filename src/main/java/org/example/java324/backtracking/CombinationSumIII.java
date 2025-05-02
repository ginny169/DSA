package org.example.java324.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public static void main(String[] args){
        int k = 3;
        int n = 7;
        System.out.println(combinationSum3(k,n));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(),0, result);
        return result;
    }
    //1->n
    public static void backtrack(int k, int n, int index, List<Integer> path, int currentSum, List<List<Integer>> result) {
        if (currentSum == n && path.size()==k) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (path.size()>k){
            return;
        }
        if (currentSum > n) {
            return;
        }
        for (int i = index; i <= n; i++) {
            path.add(i);
            backtrack(k, n, i + 1, path, currentSum + i, result);
            path.remove(path.size() - 1);
        }
    }
}
