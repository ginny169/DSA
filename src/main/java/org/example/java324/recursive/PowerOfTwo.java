package org.example.java324.recursive;

public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n <= 0) return false;
        if (n % 2 != 0) return false;
        return isPowerOfTwo(n / 2); //đệ quy n/2 đến tận n = 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2));
    }
}
