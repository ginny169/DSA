package org.example.java324.search;

import java.util.Arrays;

public class FairCandySwap {
    public static void main(String[] args) {
        int[] aliceSizes = {2};
        int[] bobSizes = {1, 3};
        System.out.println(Arrays.toString(fairCandySwap(aliceSizes, bobSizes)));

    }

    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        //sort
        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);

        int sumAlice = Arrays.stream(aliceSizes).sum();
        int sumBob = Arrays.stream(bobSizes).sum();

        int expect = (sumAlice - sumBob) / 2;
        //cần tìm phần tử ở box của alce và bob sao cho alice[i]-bob[j] = div
        for (int a : aliceSizes) {
            int ans = binarySearch(bobSizes, a - expect);
            if (ans >= 0) {
                return new int[] {
                    a, bobSizes[ans]
                } ;
            }
        }

        return new int[]{};
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
