package org.example.java324.search;

import java.util.Arrays;

public class ValidTriangleNumber {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4}; //2344 234 3
        System.out.println(triangleNumber(arr));

    }

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                int sum = nums[i] + nums[j];

                //dùng upperbound để tìm vị trí đầu tiên > sum (thoả mãn là tam giác)
                int left = j + 1, right = nums.length - 1;
                int k = j; //cần tìm k
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] < sum) {
                        k = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                result =result+(k-j);
            }

        }
        return result;
    }

}
