/*
 * ===> Question: 1: Strongly Connected Components. (SCC)
 * 
 * SCC is a component in which we can reach every vertex of the component from every other vertex in that component.
 * 
 * Component na koi pan vertex thi component na badha vertex sudhi pohchi sakie eva total strong component find out karva na che.
 * 
 * ---> We use KosaRaju Algorithm. (Reversed DFS based algorithm.)
 * 
 * Step: 1) Get nodes in stack (topological sort)
 * Step: 2) Transpose the Graph. (Copy of graph & reverse Edge)
 * Step: 3) Do DFS according to stack nodes on the transpose graph.
 * 
 * Time Complexity = O(V + E)
 */

import java.util.*;

public class A_StronglyConnectedComponents_KosaRaju_Algorithm {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // KosaRAju Algorithm.
    public static void kosaRajuAlgo(ArrayList<Edge> graph[], int V) {
        // Step 1 - Topological Sort
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!vis[i]) {
                topSort(graph, i, vis, s);
            }
        }
        System.out.println("Topological Sort = "+s);

        // Step 2 - Transpose Graph create.
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for (int i = 0; i < transpose.length; i++) {
            vis[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j); // e.src ---> e.dest
                // Reverse Edge
                transpose[e.dest].add(new Edge(e.dest, e.src)); // e.dest ---> e.src
            }
        }

        // Step 3
        while(!s.isEmpty()) {
            int curr = s.pop();
            if(!vis[curr]) {
                System.out.print("SCC -> ");
                dfs(transpose, curr, vis); // scc - Strongly Connected Components.
                System.out.println();
            }
        }
    }

    // ---> Topological sort.
    public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSort(graph, e.dest, vis, s);
            }
        }

        s.push(curr);
    }

    // ---> DFS.
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // vertex 0
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        // vertex 1
        graph[1].add(new Edge(1, 0));

        // vertex 2
        graph[2].add(new Edge(2, 1));

        // vertex 3
        graph[3].add(new Edge(3, 4));
    }
    
    public static void main(String[] args) {
        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        kosaRajuAlgo(graph, V);
    }
}
