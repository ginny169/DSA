package org.example.java324.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    public static void main(String[] args) {
        String digits = "";
        List<String> result = letterCombinations(digits);
        System.out.println(result);
    }

    public static List<String> letterCombinations(String digits) {
        String[] mapping = {
                "",     // 0
                "",     // 1
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        backtrack(digits, 0, new StringBuilder(), result, mapping);
        return result;
    }

    private static void backtrack(String digits, int index, StringBuilder path, List<String> result, String[] mapping) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String possibleLetters = mapping[digits.charAt(index) - '0'];
        for (char c : possibleLetters.toCharArray()) {
            path.append(c);
            backtrack(digits, index + 1, path, result, mapping);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
