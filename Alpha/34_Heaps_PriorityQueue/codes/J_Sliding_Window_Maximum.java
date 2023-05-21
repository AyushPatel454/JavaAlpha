/*
 * ===> Question: 4: Sliding Window Maximum.
 * Maximum of all Subarrays of size K.
 * 
 * Example: 
 * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10    K = 3
 * Ans = 3, 4, 5, 6, 7, 8, 9, 10
 * 
 * Time complexity = O(n logk)
 */

import java.util.*;

public class J_Sliding_Window_Maximum {
    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            // // ascending
            // return this.val - p2.val;

            // descending
            return p2.val - this.val;
        }
    }
    public static void main(String[] args) { // O(n logk)
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3; // Window size.

        int res[] = new int[arr.length - k + 1]; // n-k+1

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // 1st window
        for (int i = 0; i < k; i++) { // add first k element in Priority Queue.
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().val; // 1st element is our max element. Store in res array.

        for (int i = k; i < arr.length; i++) {
            while(pq.size() > 0 && pq.peek().idx <= (i-k)) { // if 1st element of out Prority Queue is not our part of window then ---> Remove 1st element of Prority Queue.
                pq.remove();
            }

            pq.add(new Pair(arr[i], i)); // add current pair.
            res[i-k+1] = pq.peek().val; // Take result from Prority queue.
        }

        // print result
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
