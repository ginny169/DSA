package org.example.java324.backtracking;

public class BinaryPrinter {
    public static void generateBinary(int n, String s) {
        if (s.length() == n) {
            System.out.println(s);
            return;
        }
        generateBinary(n, s + "0");
        generateBinary(n, s + "1");
    }

    public static void main(String[] args) {
        int n = 3;
        generateBinary(n, "");
    }
}
