package org.example.java324.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumOperationsToConvertNumber {

    public static void main(String[] args) {
        int[] nums = {2, 4, 12};
        int start = 2;
        int goal = 12;

        int result = minimumOperations(nums, start, goal);
        System.out.println(result);
    }

    public static int minimumOperations(int[] nums, int start, int goal) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] used = new boolean[1001];
        queue.add(new int[]{start,0});
        used[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            if (cur[0] == goal){
                return cur[1];
            }
            for (int next : operations(nums, cur[0])) {
                if (next == goal) {
                    return cur[1] + 1;
                }
                if (next >= 0 && next <= 1000 && !used[next]) {
                    queue.add(new int[]{next,cur[1]+1});
                    used[next] = true;
                }
            }
        }
        return -1;
    }

    public static List<Integer> operations(int[] nums, int start) {
        List<Integer> result = new ArrayList<>();
        for (int i : nums) {
            result.add(i + start);
            result.add(start - i);
            result.add((start ^ i));
        }
        return result;
    }
}
