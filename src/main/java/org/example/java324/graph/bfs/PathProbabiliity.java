package org.example.java324.graph.bfs;

import java.util.*;

public class PathProbabiliity {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        //edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2]
        // -->[0,1,0.5]
        // 0: 1,0.5 ; 2, 0,2
        //

        Map<Integer, List<Data>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.get(edges[i][0]).add(new Data(edges[i][1], succProb[i]));
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][1]).add(new Data(edges[i][0], succProb[i]));
        }

        double[] visitedMax = new double[n];
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(start_node, 1)); //node, probabilily
        visitedMax[start_node] = 0;

        while (!queue.isEmpty()) {
            Data cur = queue.remove();
            List<Data> nexts = graph.getOrDefault(cur.a, new ArrayList<>());
            for (Data next : nexts) {
                int nextNode = next.a;
                double nextProbabilily = next.probability * cur.probability;
                if (visitedMax[nextNode] < nextProbabilily) {
                    queue.add(new Data(nextNode, nextProbabilily));
                    visitedMax[nextNode] = nextProbabilily;
                }
            }
        }
        return visitedMax[end_node];
    }

    public class Data {
        public int a;
        public double probability;

        public Data(int a, double probability) {
            this.a = a;
            this.probability = probability;
        }
    }
}
