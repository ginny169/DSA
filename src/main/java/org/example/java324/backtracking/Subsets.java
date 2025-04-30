package org.example.java324.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }
    public static void backtrack(int index, int[] nums, List<Integer> path, List<List<Integer>> result){
        result.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(i+1, nums, path, result);
            path.remove(path.size()-1);
        }
    }
}
