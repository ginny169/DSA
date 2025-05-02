package org.example.java324.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SoLuongTohop {
    public static void main(String[] args) {
        int[] candidates = {1, 3, 2, 6};
        int target = 6;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack2(candidates, target, 0, new ArrayList<>(), 0,result);
        return result;
    }

    //duyệt hiệu đến khi target bằng 0;
    public static void backtrack(int[] candidates, int target, int index, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
        }
        if (target < 0) {
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, path, result);
            path.remove(path.size() - 1);
        }
    }

    //duyệt tổng đến khi bằng target
    public static void backtrack2(int[] candidates, int target, int index, List<Integer> path, int currentSum, List<List<Integer>> result) {

        if (target == currentSum) {
            result.add(new ArrayList<>(path));
        }
        if (currentSum > target) {
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack2(candidates, target, i, path,currentSum+candidates[i], result);
            path.remove(path.size() - 1);
        }
    }
}
