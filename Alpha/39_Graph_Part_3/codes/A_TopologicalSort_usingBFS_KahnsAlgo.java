/*
 * ===> Topological Sorting using BFS.
 * 
 * In-degree: Total count of incoming edges in node.
 * Out-degree: Total count of outgoing edges from node.
 * 
 * Fact:- A DAG (Directed Acyclic Graph) has at least one vertex with in-degree 0 & one vertex with out-degree 0.
 * 
 * Note: Topological Sort using DFS is solve in Graph (Part 2). This is 2nd method for Topological Sort.
 */

import java.util.*;

public class A_TopologicalSort_usingBFS_KahnsAlgo {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // ---> Topological sort. using BFS.
    public static void topSort(ArrayList<Edge> graph[]) {
        // calculate indegeree for each vertex.
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);

        Queue<Integer> q = new LinkedList<>();

        // Initially add vertex in Queue whose indegree = 0.
        for (int i = 0; i < indeg.length; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }

        // bfs
        while(!q.isEmpty()) {
            int curr = q.remove(); // remove 1st of queue.
            System.out.print(curr + " ");

            // neighbour of current vertex.
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--; // decrease indegree of neighbour of current by 1.
                if(indeg[e.dest] == 0) { // if neighbour indegree = 0 then add in Queue.
                    q.add(e.dest);
                }
            }
        }

        System.out.println();
    }

    // ---> Topological sort Helper function. (Find indgree for each vertex.)
    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int vertex = i; // my vertex.
            for (int j = 0; j < graph[vertex].size(); j++) {
                Edge e = graph[vertex].get(j);
                indeg[e.dest]++;
            }
        }
    }

    // Create Graph.
    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
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
         */

        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        topSort(graph);
    }
}
