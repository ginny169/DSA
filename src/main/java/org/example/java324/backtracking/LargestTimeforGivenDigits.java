package org.example.java324.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LargestTimeforGivenDigits {

    public static void main(String[] args){
        int[] arr = {2,0,6,6};
        System.out.println(largestTimeFromDigits(arr));
    }
    public static String largestTimeFromDigits(int[] arr) {
        List<String> result = new ArrayList<>();
        backtrack(arr,new boolean[19],new StringBuilder(),result);
        int maxhourInt = -1;
        int maxMinutesInt = -1;

        for (String res : result) {
            int hour = Integer.parseInt(res.substring(0, 2));
            if (hour < 24) {
                maxhourInt = Math.max(maxhourInt,hour);
            }
        }
        for (String res : result){
            int hour = Integer.parseInt(res.substring(0, 2));
            int minutes = Integer.parseInt(res.substring(2));
            if (hour == maxhourInt && minutes < 60) {
                maxMinutesInt = Math.max(maxMinutesInt,minutes);
            }
        }

        if (maxhourInt >= 0 && maxMinutesInt >= 0) {
            return String.format("%02d:%02d", maxhourInt, maxMinutesInt);
        } else {
            return "";
        }
    }

    /*
    1. Tìm tất các tổ hợp của số
    2. Xử lý đầu ra, nếu 2 số đầu > 23 -＞loai
    3. Xử lý 2 số cuối > 59 -->loại
    4. Chọn số lớn nhất
     */
    public static void backtrack (int[] arr, boolean[] used, StringBuilder path, List<String> result){
        if (arr.length == path.length()){
            result.add(path.toString());
            return;
        }
        for (int i = 0; i< arr.length; i++){
            if (!used[i]){
                used[i] = true;
                path.append(arr[i]);
                backtrack(arr,used,path,result);
                path.deleteCharAt(path.length() - 1);
                used[i] = false;
            }
        }
    }
}
