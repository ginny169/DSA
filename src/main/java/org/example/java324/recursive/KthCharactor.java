package org.example.java324.recursive;

public class KthCharactor {
    public static char kthCharacter(int k) {
        if (k == 1) {
            return 'a';
        }
        return func(k, "a").charAt(k - 1);
    }

    public static String func(int k, String s) {
        //ab
        //abbc
        //abbcbccd

        if (s.length() > k) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        result.append(s);
        for (char c : s.toCharArray()) {
            result.append(nextChar(c));
        }
//        System.out.println(result.toString());
        return func(k, result.toString());
    }

    public static char nextChar(char c) {
        if (c == 'z') {
            return 'a';
        } else {
            return (char) (c + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(kthCharacter(5));
    }
}
