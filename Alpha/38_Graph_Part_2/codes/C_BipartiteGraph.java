/*
 * ===> Question: 2: Bipartie Graph.
 * 
 * A Bipartite Graph is a graph whose vertices can be divided into two independent sets,
 * U and V such that every edge (u,v) either connects a vertex from U to V or a vertex
 * from V to U.
 * In other words, for every edge (u,v), either u belongs to U and v to V, or u belongs
 * to V and v to U.
 * We can also say that there is no edge that connect vertices of same set.
 * 
 * ---> We follow coloring algorihm. (For better understanding see notes.)
 * Solve using BFS approach.
 * 
 * Color Code  Color Name
 *    -1        No color.
 *     0         Yellow.
 *     1          Blue.
 * 
 *                      0 --------------- 2
 *                      |                 |         Set1       Set2
 *                      |                 |          0          1 
 *                      |                 |          3          2 
 *                      |                 |         
 *                      1 --------------- 3         It's Bipartite Graph.
 * 
 * Create Color Array[].
 * initally set all vertex has no color. -1 in color array.
 * 
 * Case i) Neighbour ---> Color is same --------> Return False (Not Bipartite.)
 * Case ii) Neighbour ---> Color is different ------> Do nothing. Continue.
 * Case iii) Neighbour ---> Color not assign ------> Assign Different color & push in queue.
 * 
 * Time complexity: O(V+E)
 * Space Complexity: O(V)
 */

import java.util.*;

public class C_BipartiteGraph {
    static class Edge {
        int src;
        int dest;

        public Edge(int s,int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // ---> isBipartite
    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) { // Assign initally -1 (NO color) for all vertex.
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) { // for visited all components of Graph. (Dis joint graph.)
            if(color[i] == -1) { // perform BFS ---> for multiple components.
                q.add(i);
                color[i] = 0; // yellow
                while(!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j); // e.dest

                        if(color[e.dest] == -1) {
                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nextColor;
                            q.add(e.dest);
                        } else if(color[e.dest] == color[curr]) {
                            return false; // NOT bipartite.
                        }
                    }
                }
            }
        }

        return true;
    }

    // Create Graph.
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>(); // Create empty arrayList in all index of Graph Array.
        }

        // vertex 0
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // vertex 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        // vertex 2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        // vertex 3
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        
        // vertex 4
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    public static void main(String[] args) {
        // If graph doesn't have cycle ---> BIPARTITE GRAPH.
        /*
         * ------------------ Graph ------------------
         *          0 ----------------- 2
         *         /                    |    Set1   Set2
         *        /                     |     0      1
         *       /                      |     3      4   
         *      1                       |     2
         *       \                      |
         *        \                     |     0's neighbour 2 has also same color like 0. So it's not bipartite graph.
         *         \                    |    
         *          3 ----------------- 4
         * ------------------ Graph ------------------
         * 
         * isBipartite = False.
         */

         int V = 5; // Total vertex.
         ArrayList<Edge> graph[] = new ArrayList[V];
 
         createGraph(graph);
         System.out.println(isBipartite(graph));
    }
}
