package org.example.java324.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    private static List<List<String>> result;

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    public static List<List<String>> partition(String s) {
        result = new ArrayList<>();
        backtrack(s, new ArrayList<>(), 0);
        return result;
    }

    public static void backtrack(String s, List<String> path, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (isPalindrome(substring)) {
                path.add(substring);
                backtrack(s, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
