package org.example.java324.backtracking;

public class TargetSum {
    /*
   You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.
     */

    public static void main(String[] args){
        int[] nums = {1};
        int target = 1;
        System.out.println(findTargetSumWays(nums,target));
    }

    static int result;
    public static int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return result;
    }

    public static void backtrack(int[] nums, int target, int sum, int index) {
        if (index == nums.length){
            if (sum == target){
                result++;
            }
            return;
        }
        backtrack(nums, target, sum + nums[index], index + 1);
        backtrack(nums, target, sum - nums[index], index + 1);
    }
}
