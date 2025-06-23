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
        Queue<Integer> queue = new LinkedList<>();
        boolean[] used = new boolean[1001];
        queue.add(start);
        used[start] = true;

        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                if (cur == goal) {
                    return result;
                }
                for (int next : operations(nums, cur)) {
                    if (next == goal) {
                        return result + 1;
                    }
                    if (next >= 0 && next <= 1000 && !used[next]) {
                        queue.add(next);
                        used[next] = true;
                    }
                }
            }
            result++;
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
