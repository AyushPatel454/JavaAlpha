/*
 * ===> Belman Ford Algorithm.
 * Shortest path from the source to all vertices. (negative edges)
 * 
 * Dijikstra's algorithm is Greedy Based. & BellmanFord algorithm is DP (Dynamic Programming) based.
 * 
 * Time complexity is high then Dijikstra's algorithm.
 * 
 * NOTE:- BELLMAN FORD IS DOESN'T WORK FOR NEGATIVE WEIGHT CYCLES.
 * 
 * 
 * Time Complexity = O(V*E)
 */

import java.util.*;

public class A_BellmanFord_Algorithm {
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

    // bellmanFord - method 1
    public static void bellmanFord(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;
        // algo - O(V*E)
        for (int i = 0; i < V-1; i++) {
            // edges - O(E) // total Edge
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);

                    // u, v, wt
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // Relaxation step.
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // print
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    // belmanForde - method 2
    public static void bellmanFord2(ArrayList<Edge> graph, int src, int V) {
        int dist[] = new int[V];

        for (int i = 0; i < dist.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // algo - O(V*E)
        for (int i = 0; i < V-1; i++) {
            // edges - O(E) // total Edge
            for (int j = 0; j< graph.size(); j++) {
                    Edge e = graph.get(j);

                    // u, v, wt
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // Relaxation step.
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
            }
        }

        // print
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    // Create graph 1
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex 0
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // vertex 1
        graph[1].add(new Edge(1, 2, -4));

        // vertex 2
        graph[2].add(new Edge(2, 3, 2));

        // vertex 3
        graph[3].add(new Edge(3, 4, 4));

        // vertex 4
        graph[4].add(new Edge(4, 1, -1));
    }

    // Create graph2
    public static void createGraph2(ArrayList<Edge> graph) {

        // vertex 0
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));

        // vertex 1
        graph.add(new Edge(1, 2, -4));

        // vertex 2
        graph.add(new Edge(2, 3, 2));

        // vertex 3
        graph.add(new Edge(3, 4, 4));

        // vertex 4
        graph.add(new Edge(4, 1, -1));
    }

    public static void main(String[] args) {
        /*
         * Graph
         *                   (2)                    (-1)
         *           0 ----------------> 1 <--------------------- 4
         *           |                   |                        ^            
         *           |                   |                        |            
         *           |                   |                        |            
         *           |(4)                | (-4)                   | (4)           
         *           |                   |                        |            
         *           |                   |                        |
         *           |                   V           (2)          |
         *           ------------------> 2 ---------------------> 3
         * 
         * -----------------------------------------------------------------
         * 
         * Shortest Path.
         * Vertex:      0    1    2   3   4
         * Distance:    0    2   -2   0   4 <---------- Answer.
         */
        int V = 5;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);
        // bellmanFord(graph, 0);
        
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph2(edges);
        bellmanFord2(edges, 0, V);


    }
}
