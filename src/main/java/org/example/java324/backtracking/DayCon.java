package org.example.java324.backtracking;

import java.util.ArrayList;
import java.util.List;

public class DayCon {

    public static void main(String[] args){
        int[] n = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        result = subsets(n);
        System.out.println(result);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,new ArrayList<>(), result, 0);
        return result;
    }
    //Input: nums = [1,2,3]
    //Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    public static void backtrack(int[] nums,List<Integer> res ,List<List<Integer>> result, int index){
        result.add(new ArrayList<>(res));
        for (int i = index; i<nums.length; i++){
            res.add(nums[i]);
            backtrack(nums, res, result, i+1);
            res.remove(res.size()-1);
        }
    }
}
