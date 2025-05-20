package org.example.java324.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutations {
    public static void main(String[] args) {
        String s = "ab12";
        System.out.println(letterCasePermutation(s));
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, result, new StringBuilder(), 0);
        return result;
    }

    public static void backtrack(String s, List<String> result, StringBuilder path, int index) {
        if (path.length() == s.length()) {
            result.add(path.toString());
            return;
        }
        if (Character.isLetter(s.charAt(index))) {
            path.append(Character.toUpperCase(s.charAt(index)));
            backtrack(s, result, path, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
        path.append(Character.toLowerCase(s.charAt(index)));
        backtrack(s, result, path, index + 1);
        path.deleteCharAt(path.length() - 1);
    }
}
//    public static List<String> removeDuplicates(List<String> input) {
//        Set<String> seen = new HashSet<>();
//        List<String> result = new ArrayList<>();
//        for (String item : input) {
//            if (!seen.contains(item)) {
//                seen.add(item);
//                result.add(item);
//            }
//        }
//        return result;
//    }
