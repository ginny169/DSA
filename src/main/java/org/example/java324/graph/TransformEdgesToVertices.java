package org.example.java324.graph;

import java.util.*;

public class TransformEdgesToVertices {
    /*
    Danh sach canh: 5 4, 1 2, 2 3, 3 1,
    out put danh sach dinh cua 1: 2 3...
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); //số lượng đỉnh
        int E = sc.nextInt(); // số lượng cạnh
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

        for (int i = 1; i <= V; i++) {
            List<Integer> neighbors = graph.get(i);
            Collections.sort(neighbors);
            if (neighbors.isEmpty()){
                continue;
            }
            System.out.print("Dinh ke cua " + i + " : ");
            for (int neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}

