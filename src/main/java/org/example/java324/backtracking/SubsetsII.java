package org.example.java324.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

//    Input: nums = [1,2,2]
//    Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

    public static void main(String[] args) {
        int[] nums = {2, 1, 2};
        List<List<Integer>> result = subsetsWithDup(nums);
        System.out.println(result);
    }

    private static List<List<Integer>> result;
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), 0);
        return result;
    }

    public static void backtrack(int[] nums, List<Integer> path, int index) {
        result.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1] ) {
                continue;
            }
            path.add(nums[i]);
            backtrack(nums, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
