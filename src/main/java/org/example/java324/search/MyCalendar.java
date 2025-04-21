package org.example.java324.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCalendar {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(book(10, 20));
        System.out.println(book(15, 25));
        System.out.println(book(20, 30));
    }

    public static List<List<Integer>> bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();
    }

    public static boolean book(int startTime, int endTime) {
        for (List<Integer> book : bookings) {
            int start = book.get(0);
            int end = book.get(1);
            if (startTime <= end && endTime >= start) {
                return false;
            }
        }
        bookings.add(List.of(startTime, endTime));
        return true;
    }

    public static boolean book2(int startTime, int endTime) {
        //{10,20}, {25, 30}, {5,10}, {15,23}
        //5, 10/10,20/15,23/25,30/
        /*
        upperbound start time mới với các start time cũ.
        if nếu start tìm đc ở vị trí 0 --> so sánh end với cái với start 0 --> nếu lớn hơn thì k làm gì
        nếu start
        nếu ở cuối so sánh start với end trước đó
        nếu ở giữa --> so sánh start với end trước và end với start sau.
         */

        int left = 0;
        int right = bookings.size() - 1;
        int ans = bookings.size();

        while (left <= right) {
            int mid = (left + right) / 2;
            if (bookings.get(mid).get(0) < startTime) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }

        //{10,20}, {5, 30} --> 5< 10, check nếu 10 < 30 --> k add đc
        if (ans < bookings.size()&& bookings.get(ans).get(0)<endTime) {
                return false;
        }
        //{5,10}, {10, 20} {8, 10}
        if (ans > 0 && bookings.get(ans-1).get(1) > startTime) {
            return false;
        }
        bookings.add(ans, Arrays.asList(startTime,endTime));
        return true;
    }
}
