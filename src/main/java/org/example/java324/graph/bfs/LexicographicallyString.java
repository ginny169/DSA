package org.example.java324.graph.bfs;

import java.util.*;

public class LexicographicallyString {

    public static void main(String[] args){
        String s = "5525";
        int a = 9, b = 2;
        System.out.println(findLexSmallestString(s,a,b));
    }
    public static String findLexSmallestString(String s, int a, int b) {
        Set<String> used = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        String result = s;
        while (!queue.isEmpty()) {
            String cur = queue.remove();
            if (cur.compareTo(result) < 0) {
                result = cur;
            }
            String next1 = addToOdd(cur, a);
            String next2 = rotateStringbyNumber(cur, b);

            if (!used.contains(next1)) {
                queue.add(next1);
                used.add(next1);
            }

            if (!used.contains(next2)) {
                queue.add(next2);
                used.add(next2);
            }
        }
        return result;
    }

    public static String addToOdd(String s, int a) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                result.append(s.charAt(i));
            } else {
                char res = (char) (a + s.charAt(i));
                if (res > '9') {
                    res = (char) (res - 10);
                }
                //(char) ((a + s.charAt(i) -'0') %10 + '0')
                result.append(res);
            }
        }
        return result.toString();
    }

    public static String rotateStringbyNumber(String s, int b) {
        String before = s.substring(0, s.length() - b);
        String after = s.substring(s.length() - b);
        String result = after + before;
        return result;
    }
}
