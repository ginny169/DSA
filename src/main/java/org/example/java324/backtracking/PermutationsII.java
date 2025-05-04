package org.example.java324.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
public class PermutationsII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result, new boolean[21]);
        return result;
    }

    public static void backtrack(int[] nums, List<Integer> path, List<List<Integer>> result, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        boolean[] dd2 = new boolean[21];
        for (int i = 0; i < nums.length; i++) {

            if (!used[i] && !dd2[nums[i]+10]) {
                dd2[nums[i]+10] = true; // loaij bo trung lap
                used[i] = true;
                path.add(nums[i]);
                backtrack(nums, path, result, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
