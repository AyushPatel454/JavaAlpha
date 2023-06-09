/*
 * Question: 3: Articulation Point. (Undirected Graph)
 * A vertex in an undirected connected graph is an articulation point (or cut vertex) if removing it (and edges through it) increases the connected components of graph.
 * 
 *      Articulation Point means graph mathi koi evi vertex ane teni badhi edges kadhi nakhiye to graph tukda ma vehchay jay ane number of tukda (component) vadhi jay.
 * 
 * ---> Solve using Tarjn Algorithm. (DFS based.S)
 * 
 * CASES:- (for Articulation Point exist.)
 * Case 1: Starting point of DFS. (whose parent = -1)
 *          Condition: ---> parent == -1 && DisconnectedChildren > 1       (if disconnected children = 1 then it's not create any extra components of graph.)
 * 
 * Case 2: Single Path exist from 'u' ---> 'v' vertex.
 *          Condition: ---> parent != -1 && discoveryTime[u] < low[v]
 * 
 * Case 3: Root of cycle. (In cycle all vertex which are part of cycle low is equal to Discovery Time of Root of cycle 'u')
 *          Condition: ---> parent != -1 && discoveryTime[u] == low[v]
 * 
 * Combine Case 2 & Case 3: ---> parent != -1 && discoveryTime[u] <= low[v]
 * 
 * 
 * 
 * Time Complexity: O(V + E)
 * 
 * see notes for better understanding...!!
 */

import java.util.*;

public class C_ArticulationPoint_TarjnAlgorithm {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // ---> Get Articulation Point.
    public static void getAP(ArrayList<Edge> graph[], int V) {
        int discoveryTime[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V]; // for not print multiple time articulation point. // track Articulation Point. // If found then we set value = true.

        for (int i = 0; i < V; i++) {
            if(!vis[i]) {
                dfs(graph, i, -1, discoveryTime, low, time, vis, ap);
            }
        }

        // Print AP (Articulation Point).
        for (int i = 0; i < ap.length; i++) {
            if(ap[i]) {
                System.out.println("AP : " + i);
            }
        }
    }

    // ---> DFS
    public static void dfs(ArrayList<Edge> graph[], int curr, int parent, int discoveryTime[], int low[], int time, boolean vis[], boolean ap[]) {
        vis[curr] = true;
        discoveryTime[curr] = low[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neighbor = e.dest;

            if(parent == neighbor) { // my neighbour is my Parent --then--> Ignore. (Continue.)
                continue;
            } else if(vis[neighbor]) { // neighbour is already visited.

                low[curr] = Math.min(low[curr], discoveryTime[neighbor]);

            } else { // neighbour is not visited.

                dfs(graph, neighbor, curr, discoveryTime, low, time, vis, ap); // visit (Go to the neighbour )the neighbour.

                low[curr] = Math.min(low[curr], low[neighbor]); // compare current low with neighbour low. // minimum low store in current low.

                if(parent != -1 && discoveryTime[curr] <= low[neighbor]) { // if current vertex is not Root (whose parent not exist) && discoveryTime[curr] <= low[neighbour]
                    ap[curr] = true; // Articulation Point 1
                    // System.out.println("AP : "+curr);
                }

                children++;
            }
        }

        // if current is starting point to DFS.
        if(parent == -1 && children > 1) { // Current is root of graph (whose parent is -1) & children of current is > 1 then current (Root) is Articulation Point.
            ap[curr] = true; // Articulation Point 2
            // System.out.println("AP : "+curr);
        }

    }

    // create graph.
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
        
        // Vertex 4
        graph[4].add(new Edge(4, 3));
    }


    public static void main(String[] args) {
        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V]; // Undirected Graph.
        createGraph(graph);

        getAP(graph, V);
    }
}
