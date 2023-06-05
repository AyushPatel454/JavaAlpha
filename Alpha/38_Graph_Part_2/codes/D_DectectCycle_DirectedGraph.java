/*
 * ===> Question: 3: Cycle detection in Directed Graph.
 * 
 * Solve, using DFS concepte.
 * small modification.
 * 
 * Time Complexity: O(V+E)
 */

import java.util.*;

public class D_DectectCycle_DirectedGraph {
    static class Edge {
        int src;
        int dest;

        public Edge(int s,int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // ---> isCycle.
    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                if(isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }

        return false;
    }

    // ---> isCycle Helper function.
    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[] ,boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]) { // cycle
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }

        stack[curr] = false; // remove from stack at return time.
        return false;
    }

    // Create Graph 1.
    public static void createGraph(ArrayList<Edge> graph[]) { // FALSE
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>(); // Create empty arrayList in all index of Graph Array.
        }

        // vertex 0
        graph[0].add(new Edge(0, 2));

        // vertex 1
        graph[1].add(new Edge(1, 0));

        // vertex 2
        graph[2].add(new Edge(2, 3));

        // vertex 3
        graph[3].add(new Edge(3, 0));
    }

    // Create Graph 2.
    public static void createGraph2(ArrayList<Edge> graph[]) { // FALSE
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>(); // Create empty arrayList in all index of Graph Array.
        }

        // vertex 0
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 1));

        // vertex 1
        graph[1].add(new Edge(1, 3));

        // vertex 2
        graph[2].add(new Edge(2, 3));

        // vertex 3
        // graph[3].add(new Edge(3, 0));
    }
    
    public static void main(String[] args) {
        /*
         * Graph
         * 1 -------------> 0 -----------------> 2 ---------> 3
         *                  ^                                  |
         *                  |                                  |
         *                  ----------------------------------  
         * 
         * Cycle exist = True.     
         */
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph); // 1st graph

        System.out.println(isCycle(graph));

        createGraph2(graph); // 2nd graph
        System.out.println(isCycle(graph));
    }
}
