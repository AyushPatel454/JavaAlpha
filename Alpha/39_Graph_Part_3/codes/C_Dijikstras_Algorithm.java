/*
 * ===> Dijikstra's Algorithm.
 * 
 * Shortest paths from the source to all vertices. (Weighted Graph)
 * 
 * Time Complexity = O(V + E logV)
 */

import java.util.*;

public class C_Dijikstras_Algorithm {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair>{ // use in Priority Queue for sortest path and vertex. (vertex, distance)
        int n; // vertex
        int path; // distance

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path; // path based sorting for my paris.
        }
    }

    // ---> Dijikstra's Algorithm.
    public static void dijkstra(ArrayList<Edge> graph[], int src) { // O(V + E logV)
        int dist[] = new int[graph.length]; // dist[i] ---> src to i distance

        for (int i = 0; i < graph.length; i++) { // Initialize all with +infinity distance.
            if(i != src) { // source ---> then distance for souce to source = 0
                dist[i] = Integer.MAX_VALUE; // +infinity 
            }
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0)); // initially pair is my src to src with distance 0;

        // loop
        while(!pq.isEmpty()) {
            Pair curr = pq.remove(); // jenu shortest distance hase e pela barr avse. (Because apde sorting na basis for badhi pair ne Priority Queue ma nakhi che.)
            if(!vis[curr.n]) { // not visited.
                vis[curr.n] = true;
                for (int i = 0; i < graph[curr.n].size(); i++) { // Neighbour of current vertex.
                    Edge e = graph[curr.n].get(i);
                    
                    // Dijikstra's Formula.
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u]+wt < dist[v]) { // update distance of src to v;
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v])); // push in priority queue. // updated
                    }
                }
            }
        }

        // print all source to vertices shortest path
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    // Create Graph.
    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex 0
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        
        // vertex 1
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        // vertex 2
        graph[2].add(new Edge(2, 4, 3));

        // vertex 3
        graph[3].add(new Edge(3, 5, 1));

        // vertex 4
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        // vertex 5
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        int src = 0;
        dijkstra(graph, src);
    }
}
