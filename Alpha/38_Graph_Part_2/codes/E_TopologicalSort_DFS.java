/*
 * ===> Topological Sort.
 * 
 * Is work on Directed Acyclic Graph (DAG) is a directed graph with no cycles.
 * Topological sorting is used only for DAGs (not for non-DAGs)
 * It is a linear order of vertices such that every Directed edge u-->v, the vertex u comes before v in the order.
 * Multiple Topological order can be exist.
 * 
 * Topological sorting is also used in Dependency Graph.
 * 
 * 
 * We can perform Topological sorting using DFS.
 * 
 * Time Complexity: O(V+E)
 */

import java.util.*;

public class E_TopologicalSort_DFS {
    static class Edge {
        int src;
        int dest;

        public Edge(int s,int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // ---> Topological Sort
    public static void topSort(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }

        while(!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }

    // helper function of Topological Sort
    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }

        s.push(curr); // Add current after adding Neighbours in Stack.
    }

    // Create Graph 1.
    public static void createGraph(ArrayList<Edge> graph[]) { // FALSE
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>(); // Create empty arrayList in all index of Graph Array.
        }

        // vertex 0

        // vertex 1

        // vertex 2
        graph[2].add(new Edge(2, 3));

        // vertex 3
        graph[3].add(new Edge(3, 1));

        // vertex 4
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        // vertex 5
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void main(String[] args) {
        /* ----------------------------- Graph -----------------------------
         * 
         *              5 ----------------> 0 <---------------- 4
         *             /                                      /
         *            /                                      /
         *           /                                      /
         *          /                                      /
         *         V                                      V
         *        2 ----------------> 3 ----------------> 1
         * 
         * ----------------------------- Graph -----------------------------
         * 
         * Topological Ans = 5, 4, 2, 3, 1, 0
         * 
         *                                                                           ------------> Pop one by one.  Ans = 5, 4, 2, 3, 1, 0
         *                                                                          |  
         *                                                                          |  
         *                                                                    |           |
         *   5's neighbour not exist. Add 5                                   |  -> 5 <-  |
         *   ______________________________________                           |___________|
         *   4's neighbour not exist. Add 4                                   |  -> 4 <-  |
         *   ______________________________________                           |___________|
         *   Add 2 at last after add all neighbour.                           |  -> 2 <-  |
         *   3 is neighbour is 2. add it.                                     |     3     |      // 3 is neighbour of 2 add it. 
         *   ______________________________________                           |___________|
         *   1's neighbour not exist. Add 1                                   |  -> 1 <-  |
         *   ______________________________________                           |___________|
         *   0's neighbour not exist. Add 0                                   |  -> 0 <-  |
         *                                                                    ------------
         */
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        topSort(graph);
    }
}
