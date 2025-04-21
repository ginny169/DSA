package org.example.java324.search;

import java.util.*;

public class MostProfitAssignWork {
    public static void main(String[] args) {
        int[] difficulty = {5,50,92,21,24,70,17,63,30,53};
        int[] profit = {68,100,3,99,56,43,26,93,55,25};
        int[] worker = {96,3,55,30,11,58,68,36,26,1};

        int total = maxProfitAssignment(difficulty, profit, worker);
        System.out.println("Total maximum profit: " + total);
    }

    public static class Job {
        int difficulty;
        int profit;
        int maxProfit;

        public Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;

        }
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        /*
        ý tưởng coi từng phần tử ở worker là target
        duyệt dificulty --> lấy phần từ lớn nhất có giá trị <= worker.
        */

        int n = difficulty.length;
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new Job(difficulty[i], profit[i]));
        }

        //sắp xếp job theo độ khó
        jobs.sort(Comparator.comparingInt(j -> j.difficulty));

        //xử lý dificult và profit theo max profit
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(jobs.get(i).profit, max);
            jobs.get(i).maxProfit = max;
        }

        int total = 0;
        for (int w : worker) {
            int index = findUpperBound(jobs, w);
            if (index > 0) {
                total = total + jobs.get(index - 1).maxProfit;
            }
        }
        return total;
    }

    public static int findUpperBound(List<Job> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        int ans = arr.size();

        while (left <= right) {
            int mid = left + (right-left)/2;
            if (arr.get(mid).difficulty > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
