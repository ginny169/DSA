package org.example.java324.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomsAndKeys {

    public static void main(String[] args){
        System.out.println("abc");
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] used = new boolean[rooms.size()+1];
        used[0] = true;
        dfs(0, rooms, used);
        for (int i = 0; i < used.length; i++){
            if (!used[i]){
                return false;
            }
        }
        return true;
    }
    public static void dfs(int start,List<List<Integer>> input, boolean[] used){
        List<Integer> neighbors = input.get(start);
        for (int i = 0; i < neighbors.size()+1; i++){
            if (!used[neighbors.get(i)]){
                used[neighbors.get(i)] = true;
                dfs(neighbors.get(i),input,used);
            }
        }
    }
}
