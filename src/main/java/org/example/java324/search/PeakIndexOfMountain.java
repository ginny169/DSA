package org.example.java324.search;

public class PeakIndexOfMountain {
    public static void main(String[] args) {
        int[] arr = {0, 10, 5, 2};
        System.out.println(peakIndexInMountainArray(arr));

    }

    public static int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length - 2;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
