/*
 * ===> Kruskal's Algorithm.
 * 
 * Used for find Minimum Spanning Tree (MST) like Prim's Algorithm.
 * 
 * Method Used: MST Greedy.
 * 
 * Step: 1) Sort Edges.
 * Step: 2) Take minimum cost Edge 
 *           ***(Not take Edge if it create cycle)***
 *          Include ans.
 * 
 * Time Complexity = O(V + E logE)
 */

import java.util.*;

public class D_Kruskals_Algorithm {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt; // sort on basis of cost (Weight) in Ascending Order.
        }
    }

    public static void createGraph(ArrayList<Edge> edges) {
        // edges
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0,3, 30));
        edges.add(new Edge(1,3, 40));
        edges.add(new Edge(2,3, 50));
    }

    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if(par[x] == x) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if(par[parA] == par[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if(par[parA] < par[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    // ---> Kruskal's Algorithm.
    public static void kruskalsMST(ArrayList<Edge> edges, int V) {
        init(); // initialise Disjoint Algorithm.

        Collections.sort(edges); // O(E logE)
        int mstCost = 0;
        int count = 0; // how many edges inculde in my MST.

        for (int i = 0; count < V-1; i++) { // O(V)
            Edge e = edges.get(i);

            // (src, dest, wt)
            int parA = find(e.src); // src = a;
            int parB = find(e.dest); // dest = b;

            if(parA != parB) { // If not create cycle.
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }

        System.out.println("Count = "+count+"\nMST cost = "+mstCost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();

        createGraph(edges);
        
        kruskalsMST(edges, V);
    }
}
