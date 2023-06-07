/*
 * ===> Question: 2: Connecting Cities with minimum Cost.
 * 
 * Find the minimum cost for connecting all cities on the map.
 */

import java.util.*;

public class B_ConnectingCities {
    static class Edge implements Comparable<Edge>{
        int dest; // destination.
        int cost;

        public Edge(int d, int cost) {
            this.dest = d;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e2) { // sort on basis of cost.
            return this.cost - e2.cost; // ascending order.
        }
    }

    // Prims Algorithm.
    public static int connectCities(int cities[][]) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(); 
        boolean vis[] = new boolean[cities.length]; // for check vertex is visited or not. Initially all are false (Unvisited).

        pq.add(new Edge(0, 0)); // src = 0, Cost = 0 <--- (Initially)
        int finalCost = 0;

        // Prim's algorithm.
        while(!pq.isEmpty()) {
            Edge curr = pq.remove();
            if(!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;

                // Neighbour.
                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if(cities[curr.dest][i] != 0) {
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }

        return finalCost;
    }

    public static void main(String[] args) {
        int cities[][] =    {{0, 1, 2, 3, 4}, // Total cities = cities.length = 5
                            {1, 0, 5, 0, 4}, // cities[i][j] ---> distance between i vertext to j vertex.
                            {2, 5, 0, 6, 0},
                            {3, 0, 6, 0, 0},
                            {4, 7, 0, 0, 0}};

        System.out.println(connectCities(cities));
    }
}
