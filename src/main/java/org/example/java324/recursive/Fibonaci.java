package org.example.java324.recursive;

public class Fibonaci {
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return (fib(n - 1) + fib(n - 2));
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
        double degrees = Math.toDegrees(3);
        System.out.println("degrees = " + degrees);
    }
}

