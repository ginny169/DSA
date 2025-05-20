package org.example.java324.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFSundirect {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); //số lượng đỉnh
        int E = sc.nextInt(); // số lượng cạnh
        int K = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(); //điểm đầu
            int v = sc.nextInt(); // điểm cuối

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] used = new boolean[V+1];
        used[K] = true;
        dfs(K,graph,used);
    }

    public static void dfs (int start, List<List<Integer>> input, boolean[] used){
        System.out.print(start+" ");
        List<Integer> dinhkeStart = input.get(start);
        for (Integer a : dinhkeStart){
            if (!used[a]){
                used[a] = true;
                dfs(a,input,used);
            }
        }
    }
}
