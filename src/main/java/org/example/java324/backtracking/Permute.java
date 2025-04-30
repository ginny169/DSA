package org.example.java324.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    public static void main(String[] args){
        int[] n = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        result = permute(n);
        System.out.println(result);
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,new boolean[nums.length],new ArrayList<>(),result);
        return result;
    }

//    Input: nums = [1,2,3]
//    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    public static void backtrack (int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result){
        //ddk dừng path.size() = k
        if (path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i<=nums.length-1; i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                backtrack(nums,used,path,result);
                used[i] = false;
                path.remove(path.size()-1);

            }
        }
    }
}
