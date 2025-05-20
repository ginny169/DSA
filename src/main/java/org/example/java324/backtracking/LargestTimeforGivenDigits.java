package org.example.java324.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestTimeforGivenDigits {

    public static void main(String[] args) {
        int[] arr = {2, 0, 6, 6};
        System.out.println(largestTimeFromDigits(arr));
    }

    public static String largestTimeFromDigits(int[] arr) {
        List<Integer> arr1 = new ArrayList<>();
        for (int a : arr) {
            arr1.add(a);
        }
        Collections.sort(arr1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        List<String> result = new ArrayList<>();
        backtrack(arr1, new boolean[19], new StringBuilder(), result);

        for (String res : result) {
            int hour = Integer.parseInt(res.substring(0, 2));
            int minutes = Integer.parseInt(res.substring(2));
            if (hour < 24 && minutes < 60) {
                return String.format("%02d:%02d", hour, minutes);
            }
        }
        return "";
    }

    /*
    1. Tìm tất các hoán vi của số
    2. Xử lý đầu ra, nếu 2 số đầu > 23 -＞loai
    3. Xử lý 2 số cuối > 59 -->loại
    4. Chọn số lớn nhất
     */
    public static void backtrack(List<Integer> arr, boolean[] used, StringBuilder path, List<String> result) {
        if (arr.size() == path.length()) {
            result.add(path.toString());
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                path.append(arr.get(i));
                backtrack(arr, used, path, result);
                path.deleteCharAt(path.length() - 1);
                used[i] = false;
            }
        }
    }
}
