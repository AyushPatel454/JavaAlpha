/*
 * ===> Question: 1: Nearby Cars.
 * We are given N points in 2D plane which are locations of N cars.
 * If we are at the origin, print the nearest K cars.
 * 
 * Example:
 * C0 (3,3)
 * C1 (5,-1)
 * C2 (-2,4)
 * 
 * Answer:  C0 & C2
 * 
 * Finding distance using. ---> d = (x^2 + y^2)^(1/2)
 * But we find out distance squre. d^2 = (x^2 + y^2)
 */

import java.util.*;

public class G_NearbyCars {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq; // ascending order.
        }
    }

    public static void main(String[] args) {
        int pts[][] = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length; i++) {
            int distSq = (pts[i][0]*pts[i][0]) + (pts[i][1]*pts[i][1]);
            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        // nearest K cars
        System.out.println("Nearest cars:");
        for (int i = 0; i < k; i++) {
            System.out.println("C"+pq.remove().idx);
        }
    }
}
