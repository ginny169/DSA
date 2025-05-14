package org.example.java324.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterCasePermutations {
    public static void main(String[] args){
        String s = "ab12";
        System.out.println(letterCasePermutation(s));
    }
    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s,result,new StringBuilder(),new boolean[12],0);
        return removeDuplicates(result);
    }
    public static void backtrack(String s, List<String> result, StringBuilder path, boolean[] used, int index){
        if (path.length() == s.length()){
            result.add(path.toString());
            return;
        }
        for (int i = index; i < s.length(); i++){
            if (!used[i]){

                used[i] = true;
                path.append(Character.toUpperCase(s.charAt(i)));
                backtrack(s,result,path,used,i+1);
                used[i] = false;
                path.deleteCharAt(path.length() - 1);
                
                path.append(Character.toLowerCase(s.charAt(i)));
                backtrack(s,result,path,used, i+1);
                path.deleteCharAt(path.length() - 1);
                used[i] = false;
            }
        }
    }
    public static List<String> removeDuplicates(List<String> input) {
        Set<String> seen = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (String item : input) {
            if (!seen.contains(item)) {
                seen.add(item);
                result.add(item);
            }
        }
        return result;
    }
}
