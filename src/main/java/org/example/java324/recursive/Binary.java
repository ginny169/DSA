package org.example.java324.recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> result = binary(n);
        for (String value:result){
            System.out.println(value);
        }
    }

    public static List<String> binary(int n) {
        //Số nhị phân là số chỉ chứa số 0 và số 1. In ra tất cả các số nhị phân có 𝑁
        // chữ số.
        // n =1:  '0' va '1'
        //n = 2: 00, 01, 10, 11
        //n=3: 000, 001, 011, 010, 100, 101, 110, 111

        List<String> result = new ArrayList<>();
        if (n == 1) {
            result.add("0");
            result.add("1");
            return result;
        }
        List<String> list = binary(n - 1);
        for (String value : list) {
            result.add(value + "0");
            result.add(value + "1");
        }
        return result;
    }
}
