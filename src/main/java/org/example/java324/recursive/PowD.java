package org.example.java324.recursive;

public class PowD {
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n < 0){
            return 1/myPow(x,-n);
        }
        return x * myPow(x, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.1000, -3));
    }
}
