package org.example.java324.recursive;

public class KthCharactor {
    public static char kthCharacter(int k) {
        if (k == 1) {
            return 'a';
        }
        return nextChar(kthCharacter(k-1));
    }

    public static char nextChar(char c) {
        return c == 'z' ? 'a' : (char)(c + 1);
    }

    public static void main(String[] args) {
        System.out.println(kthCharacter(5));
    }
}
