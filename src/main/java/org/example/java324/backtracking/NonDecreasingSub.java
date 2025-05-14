package org.example.java324.backtracking;

import java.util.*;

public class NonDecreasingSub {
    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        System.out.println(findSubsequences(nums));
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return removeDuplicates(result);
    }

    public static void backtrack(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        for (int i = index; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)) {
                continue;
            }
            path.add(nums[i]);
            backtrack(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static List<List<Integer>> removeDuplicates(List<List<Integer>> input) {
        Set<String> seen = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        for (List<Integer> seq : input) {
            String key = seq.toString();
            if (!seen.contains(key)) {
                seen.add(key);
                result.add(seq);
            }
        }
        return result;
    }
}
