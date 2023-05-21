/*
 * ===> Question: 2: Connect N Ropes.
 * Given are N ropes of different lengths, the task is to connect these ropes into
 * one rope with minimum cost, such that the cost to connect two (2) ropes is equal
 * to the sum of their lengths.
 * 
 * ropes = {4, 3, 2, 6}
 * ans = 29
 * 
 * Explanation:
 * connect 2 & 3 [5]
 * connect 5 & 4 [9]
 * connect 9 & 6 [15]
 */

import java.util.*;

public class H_Connect_N_Ropes {
    public static void main(String[] args) {
        int ropes[] = {2, 3, 3, 4, 6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;
        while(pq.size() > 1) {
            int min = pq.remove();
            int min2 = pq.remove();

            cost += min + min2;

            pq.add(min+min2);
        }

        System.out.println("Cost of connection n ropes = "+cost);
    }
}
