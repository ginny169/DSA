package org.example.java324.recursive;

public class PowerOfTwo {
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
        //2*16 = 2^8 * 2^8
        //2^15 = 2* 2^7*2^7
        if (n%2!=0){
            return x * myPow(x, n/2) * myPow(x, n/2);
        } else {
            return myPow(x, n/2)*myPow(x, n/2);
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 3));
    }
}
