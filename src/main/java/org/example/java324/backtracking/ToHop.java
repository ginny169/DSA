package org.example.java324.backtracking;

import java.util.ArrayList;
import java.util.List;

public class ToHop {

    public static void main(String[] args){
        int n = 5;
        int k = 3;
        List<List<Integer>> result = tohop(n,k);
        System.out.println(result);
    }
    public static List<List<Integer>> tohop(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n,k,1,new ArrayList<>(),result);
        return result;
    }
    public static void backtrack (int n, int k, int index, List<Integer> path, List<List<Integer>> result){
        //ddk dừng path.size() = k
        if (path.size()==k){
            result.add(new ArrayList<>(path));
            return;
        }
        //n-k+path.size+1
        // i = 1, i<=2+0+1
        //i=2, i<= 2+1+1
        //i=3, i<=2+2+1
        for (int i = index; i<=n-k+path.size()+1; i++){
            path.add(i);
            backtrack(n,k,i+1,path,result);
            path.remove(path.size()-1);
        }
    }


}
