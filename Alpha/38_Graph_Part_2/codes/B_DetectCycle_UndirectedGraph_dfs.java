/*
 * ===> Question: 1: Cycle Detection in Undirected Graph.
 * 
 * Using DFS.
 * 
 * Time complexity: O(V+E)
 * 
 * ---> 3 cases.
 * Case i) visited[Neighoubr] = True && Neighbour is not our parent.
 *          ---> CYCLE EXIST. Return True.
 * Case ii) visited[Neighbour] = True && Neighbour is our parent.
 *          ---> Do nothing.
 * Case iii) Visited[Neighbour] = False
 *          ---> Noram DFS call(neighbour)
 *                 if Cycle exist then return True. Otherwise False.
 */

import java.util.*;

public class B_DetectCycle_UndirectedGraph_dfs {
    static class Edge {
        int src;
        int dest;

        public Edge(int s,int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // ---> Detect Cycle. -----> Time Complexity = O(V+E)
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) { // This loop for many componetnts. There is possiblity to if graph disjoint. And In component Graph there is no cycle but there is possiblity in component 2 there is cycle exist. So thats why we take loop for visit all components.
            if(!vis[i]) {
                // Call DetectCycleUtil. ---> If it's return TRUE --then--> Return True and goto in main function.
                if(detectCycleUtil(graph, vis, i, -1)) { // Pass Parent = -1. Becaues it's src node & it's not exist it's parent node.
                    System.out.println();
                    System.out.println("After that cycle detect.");
                    return true;
                    // cycle exists in one of the parts.
                }
            }
        }

        System.out.println();
        System.out.print("All vertex is visited. So Answer = ");

        return false;
    }

    // Helper function.
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int parent) {
        // vis[curr] = true;
        if(!vis[curr]) { // not visited.
            System.out.print(curr + " ");
            vis[curr] = true;
        }

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // case 3
            if(!vis[e.dest]) { // neighbour not visited
                if(detectCycleUtil(graph, vis, e.dest, curr)) { // detect cycle detect by neighbour or not.
                    return true;
                }
            }
            // case 1
            else if(vis[e.dest] && e.dest != parent) { // neighbour is not parent means cycle exist.
                return true;
            }
            // case 2 -> do nothing -> continue.
        }

        return false; // if cycle not detect
    }

    // Create Graph.
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>(); // Create empty arrayList in all index of Graph Array.
        }

        // vertex 0
        graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        // vertex 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // vertex 2
        // graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        // vertex 3
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        
        // vertex 4
        graph[4].add(new Edge(4, 3));
    }

    public static void main(String[] args) {
        /*
         * ------------------ Graph ------------------
         * 
         *              0 --------- 3
         *            / |           |
         *           /  |           |
         *          1   |           |
         *           \  |           |
         *            \ |           |
         *              2           4
         * 
         * ------------------ Graph ------------------
         * 
         * Detect Cycle = True. (0,1,2)
         */

         int V = 5; // Total vertex.
         ArrayList<Edge> graph[] = new ArrayList[V];
 
         createGraph(graph);
        
         System.out.println("Visted Node: ");
         System.out.println(detectCycle(graph));
    }
}
