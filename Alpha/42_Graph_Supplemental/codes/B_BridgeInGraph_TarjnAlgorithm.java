/*
 * ===> Question: 2: Bridge in Graph. (Undirected Graph)
 * Bridge is an edge whose deletion increases the graph's number of connected components.
 * 
 * ===> Tarjan's Algorithm.
 *      For find the bridge in given undirected graph.
 * 
 * Time Complexity: O(V + E)
 * 
 * see notes for better understanding...!!
 */

import java.util.*;

public class B_BridgeInGraph_TarjnAlgorithm {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }


    // ---> Tarjan's Algorithm ---for---> Bridge detect in Undirected Graph.
    public static void tarjanBridge(ArrayList<Edge> graph[], int V) {
        int discoveryTime[] = new int[V]; // discovery time of vertex.
        int low[] = new int[V]; // low : lowest discovery time of all neighbors.
        boolean vis[] = new boolean[V];
        int time = 0; // intially time is 0.

        for (int i = 0; i < V; i++) {
            if(!vis[i]) {
                dfs(graph, i, -1, discoveryTime, low, vis, time);
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int parent, int discoveryTime[], int low[], boolean vis[], int time) {
        vis[curr] = true;
        discoveryTime[curr] = low[curr] = ++time;
        
        // Neighbors of current vertex.
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i); // e.src --- e.dest
            int neighbour = e.dest;

            if(neighbour == parent) { // if my Neighbor is my parent of current vertex. ---> Do nothing. ---> Continue.
                continue;
            } else if(!vis[neighbour]) { // Neighbour is unvisited.

                dfs(graph, neighbour, curr, discoveryTime, low, vis, time); // dfs

                low[curr] = Math.min(low[curr], low[neighbour]); // compare Low of current with neighbors low.

                if(discoveryTime[curr] < low[neighbour]) { // discovery time of current is < neighbor low ---then---> Bridge exist between current vertex & neighbor.
                    System.out.println("Bridge : "+ curr + " ----------- " + neighbour);
                }
            } else { // Neighbor is already visited.
                low[curr] = Math.min(low[curr], discoveryTime[neighbour]); // compare Low of current with neigbors discovery time. & Minimum is store in Low[current] array.
            }
        }
    }

    // Create Graph
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Vertex 0
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        // Vertex 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // Vertex 2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        // Vertex 3
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        // Vertex 4
        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // Vertex 5
        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));
    }

    public static void main(String[] args) {
        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V]; // Undirected Graph.
        createGraph(graph);

        tarjanBridge(graph, V);
    }
}
