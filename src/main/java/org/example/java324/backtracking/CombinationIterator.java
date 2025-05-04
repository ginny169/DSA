package org.example.java324.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationIterator {

    private static int last;
    private static List<String> combinations;

    public static void main(String[] args) {
        String characters = "chp";
        int length = 1;
        CombinationIterator obj = new CombinationIterator(characters, length);
//        System.out.println(combinations);
        String param_1 = obj.next();
        System.out.println(param_1);
        boolean param_2 = obj.hasNext();
        System.out.println(param_2);
        param_1 = obj.next();
        System.out.println(param_1);
        param_2 = obj.hasNext();
        System.out.println(param_2);
        param_1 = obj.next();
        System.out.println(param_1);
        param_2 = obj.hasNext();
        System.out.println(param_2);
        param_1 = obj.next();
        System.out.println(param_1);
        param_2 = obj.hasNext();
        System.out.println(param_2);
        param_1 = obj.next();
        System.out.println(param_1);
        param_2 = obj.hasNext();
        System.out.println(param_2);

    }

    public CombinationIterator(String characters, int combinationLength) {
        combinations = new ArrayList<>();
        last = 0;
        backtrack(characters, combinationLength, 0, new StringBuilder());

    }

    public static void backtrack(String characters, int n, int index, StringBuilder path) {
        if (path.length() == n) {
            combinations.add(path.toString());
            return;
        }
        for (int i = index; i < characters.length(); i++) {
            path.append(characters.charAt(i));
            backtrack(characters, n, i + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public String next() {
        return hasNext() ? combinations.get(last++) : "";
    }

    public boolean hasNext() {
        return last < combinations.size();
    }

}
