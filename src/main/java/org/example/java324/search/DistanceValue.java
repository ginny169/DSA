package org.example.java324.search;

import java.util.Arrays;

public class DistanceValue {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 2, 3};
        int[] arr2 = {-4, -3, 6, 10, 20, 30};
        int d = 3;
        System.out.println(findTheDistanceValue(arr1, arr2, d));
    }

    //sắp xếp mảng 2:   1  8 9 10
    //[4-1], [4-8], [4-9], [ 4-10]
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int result = 0;
        boolean flag = true;
        for (int value : arr1) {
            int index = findLowerBound(arr2, value);
            if (index != arr2.length) {
                if (Math.abs(arr2[index] - value) <= d) {
                    flag = false;
                }
            }
            if (index > 0) {
                if (Math.abs(arr2[index - 1] - value) <= d) {
                    flag = false;
                }
            }
            if (flag) {
                result += 1;
            }
            flag = true;
        }
        return result;
    }

    public static int findLowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ans = arr.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
