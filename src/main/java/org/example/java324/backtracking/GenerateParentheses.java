package org.example.java324.backtracking;

import java.util.ArrayList;
import java.util.List;

//Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]

public class GenerateParentheses {
    private static List<String> result;

    public static void main(String[] args){
        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        backtrack(n,new StringBuilder(),0,0);
        return result;
    }

    public static void backtrack(int n, StringBuilder path, int open, int close) {
        if (path.length() == 2 * n) {
            result.add(path.toString());
        }
        if (open < n){
            path.append("(");
            backtrack(n,path,open+1,close);
            path.deleteCharAt(path.length()-1);
        }
        if (close < open){
            path.append(")");
            backtrack(n,path,open,close+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
