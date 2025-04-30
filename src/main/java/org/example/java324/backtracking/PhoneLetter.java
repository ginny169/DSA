package org.example.java324.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PhoneLetter {

    public static void main(String[] args){
        String digit = "";
        System.out.println(letterCombinations(digit));
    }

    public static List<String> letterCombinations(String digits){
        List<String> result = new ArrayList<>();
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
        backtrack(mapping,0,new StringBuilder(),result,digits);
        return result;
    }

    //Input: digits = "23"
    //Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    public static void backtrack(String[] mapping,int index, StringBuilder res,List<String> result, String digits){
        //điều kiện dừng là res.length = digits.length
        if (res.length() == digits.length()){
            result.add(new String(res));
            return;
        }
        int indexD = digits.charAt(index)-'0';
        String inputData = mapping[indexD];
        for (int i = 0; i<inputData.length();i++){
            res.append(inputData.charAt(i));
            backtrack(mapping, index+1, res, result, digits);
            res.deleteCharAt(res.length()-1);
        }
    }
}
