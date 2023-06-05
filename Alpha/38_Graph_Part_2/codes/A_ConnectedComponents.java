/*
 * ===> Connected Components.
 * 
 * If graph is disjoint then we can't traverse. See Graph in blow.
 * 
 *           0---5               6
 *          /                  /  \ 
 *         1   4              7    8                13
 *          \ /              /\   / \
 *      3----2              9 10 11 12
 * 
 *      Component 1        Component 2          Component 3
 * 
 * If we want to traverse from Source 0 to Destination 13. ---> We can not traverse only BFS & DFS fucntion.
 * 
 * We need to modify our BFS & DFS  function. Other wise logica is same.
 * 
 * ---> We create 2 fuctions. 
 *      i) BFS/DFS
 *     ii) bfsUtil / dfsUtil ---> (Helper function)
 * 
 * ===> Totoal number of calls to Helper function = total components in our Graph
 * 
 * in above graph 3 components it means there 3 calls go from bfs/dfs --to--> bfsUtil/dfsUtil (Helpter function)
 * 
 * Time Complexity: O(V+E)
 */

import java.util.*;

public class A_ConnectedComponents {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s,int d) {
            this.src = s;
            this.dest = d;
            this.wt = 1;
        }
    }

    // ---> BFS
    public static void bfs(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length]; // All elements of Visited are False. = [F,F,F,F,F,F,F]
        
        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]) { // not visited.
                bfsUtil(graph, i, visited); // call bfsUtil ---> Which is Traverse in BFS. & Print element in BFS traverse.
            }
        }
        System.out.println();
    }

    // ---> BFSUtil --> BfsHelper
    public static void bfsUtil(ArrayList<Edge> graph[], int src, boolean visited[]) {
        Queue<Integer> q = new LinkedList<>();

        q.add(src);

        while(!q.isEmpty()) {
            int curr = q.remove();
            if(!visited[curr]) { // current not visited ... ... ...
                visited[curr] = true;
                System.out.print(curr+" ");
                // find neighbour
                for (int i = 0; i < graph[curr].size(); i++) {
                    q.add(graph[curr].get(i).dest); // add neighobour in queue.
                }
            }
        }
    }

    // ---> DFS
    public static void dfs(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            dfsUtil(graph,i,visited);
        }
        System.out.println();
    }

    // ---> DFSUtil ---> Dfs helper.
    public static void dfsUtil(ArrayList<Edge> graph[], int curr, boolean visited[]) {
        if(!visited[curr]) { // not visited.
            System.out.print(curr + " ");
            visited[curr] = true;
        }
        
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]) {
                dfsUtil(graph,e.dest,visited);
            }
        }
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
        graph[1].add(new Edge(1, 7));

        // vertex 7
        graph[7].add(new Edge(7, 1));

        // vertex 2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));

        // vertex 3
        graph[3].add(new Edge(3, 2));
        
        // vertex 4
        graph[4].add(new Edge(4, 5));
        graph[4].add(new Edge(4, 6));
        
        // vertex 5
        graph[5].add(new Edge(5, 4));
        
        // vertex 6
        graph[6].add(new Edge(6, 4));
    }

    public static void main(String[] args) {
        /*
         * ------------------ Graph ------------------
         * 
         *          0                    4 ---- 6
         *        /  \                  / 
         *       1   2                 / 
         *      /     \               5  
         *     7       3            
         * 
         *    Component 1             Component 2
         * ------------------ Graph ------------------
         * 
         * Find BFS & DFS of above graph.
         * BFS = 0 1 2 7 3 4 5 6
         * DFS = 0 1 7 2 3 5 5 6
         */

        int V = 8; // Total vertex.
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        System.out.print("BFS: ");
        bfs(graph);
        System.out.print("DFS: ");
        dfs(graph);
    }
}
