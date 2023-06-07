/*
 * ===> Question: 1: Cheaptest Flights with K stops.
 * 
 * There are n cities connected by some number of flights. Yor are given an array flights where
 * flights[i] = [from, to, price] indicates that there is a flight.
 * You are also given 3 Integers src, dest & K, return the cheapest price from src to dest with at most
 * K stops.
 * 
 * If there is no such route, return -1;
 * 
 * K ---> Show that maximum stops avialbe from source to destination.
 */

import java.util.*;

public class A_Cheapest_Flights_with_K_stops {
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

    static class Info {
        int vertex;
        int cost;
        int stops;

        public Info(int v, int c, int s) {
            this.vertex = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
        // Create Graph.
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        int dist[] = new int[n]; // distance of each vertex from source.
        for (int i = 0; i < n; i++) {
            if ( i != src) {
                dist[i] = Integer.MAX_VALUE; // Initially Each vertex distance = +Infinity.
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0)); // (source, cost, stops.) // initially cost = 0 & stop of source = 0.

        while(!q.isEmpty()) {
            Info curr = q.remove();

            if(curr.stops>k) { // current stop > k stops then break.
                break;
            }

            for (int i = 0; i < graph[curr.vertex].size(); i++) { // Neighbour of current.
                Edge e = graph[curr.vertex].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                // Relxation
                if(curr.cost + wt < dist[v] && curr.stops <= k) { // dist[u] != Integer.MAX_VALUE ---> Because in java +infinity + value = -ve value.
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }


        // dist[dest]
        if(dist[dest] == Integer.MAX_VALUE) { // destination cost = +Infinity
            return -1; // No path found with k stops.
        } else {
            return dist[dest];
        }
    }

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            // Edge inforamtion.
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            // Add edge in graph.
            graph[src].add(e);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dst = 3, k = 1;

        int ans = cheapestFlight(n, flights, src, dst, k);

        System.out.println("Ans = "+ans);
    }
}
