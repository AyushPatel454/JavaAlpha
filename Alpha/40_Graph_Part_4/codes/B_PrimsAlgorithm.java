/*
 * ===> Prim's Algorithm.
 * ------> Prim's Algorithm used for find Minimum spanning Tree (MST) in given graph.
 * 
 * ---> Minimum Spanning Tree (MST)
 *          A minimum spanning Tree (MST) or minimum weight spanning tree is a subset
 * of the edges of a connected, edge - weight undirected graph that connects all the 
 * vertices together, without any cycles & with the minimum possible total edge weight.
 * 
 *      1 unidrected weighted graph apelo hase. Ema thi evo sub graph shodhvano che jema
 * darek vertex avi jay connect ma ane temna vachhe nu Edge nu weight pan occhu hoy & overall
 * cost sou thi minimum hoy & ema koi cycle pan na hoy.
 * 
 * We, can find out Minimum Spanning Tree (MST) with help of Prim's Algorithm.
 * 
 * In graph there is many spanning tree, but we find out minimum spanning tree.
 */

import java.util.*;

public class B_PrimsAlgorithm {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static class Pair implements Comparable<Pair>{
        int v; // vertex
        int cost; // cost

        public Pair(int v, int c) {
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; // ascending.
        }
    }

    public static void prims(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0)); // src, cost

        int finalCost = 0; // MST Cost / Total min Weight.

        while(!pq.isEmpty()) {
            Pair curr = pq.remove(); // Remove vertex whose cost is low.

            if(!vis[curr.v]) {
                vis[curr.v] = true;

                // add in MST
                finalCost += curr.cost;
                // Add neighbours.
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        System.out.println("Final (minimum) cost of MST = "+finalCost);
    }

    // Create graph
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex 0
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        // vertex 1
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        // vertex 2
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        // vertex 3
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static void main(String[] args) {
        /*
         * Graph
         *               -------------------- 0 --------------------                          
         *               |       (10)         |         (15)       |                          
         *               |                    |                    |                          
         *               |                    |                    |                          
         *               1                    | (30)               2                          
         *               |                    |                    |                          
         *               |                    |                    |                          
         *               |      (40)          |         (50)       |                          
         *               -------------------- 3 --------------------   
         * 
         * _____________________________________________________________________
         * 
         * MST: 
         *      1 ----------------- 0 ----------------- 2
         *               (10)       |        (15)
         *                          |
         *                          | (30)
         *                          |
         *                          |
         *                          3
         * 
         * Minimum Cost = 10 + 30 + 15 = 55 
         * _____________________________________________________________________
         */
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        prims(graph);
    }
}
