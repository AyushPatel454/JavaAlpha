/*
 * ===> Priority Queue.
 * 
 * Store element priority/Ranked wise.
 * Example: 11, 3, 5, 9, 2 ----> 2 has highest priority. ---> pq: 2, 3, 5, 9, 11
 * 
 * Simillar functions as Queue.
 * add() ---> O(log n) ---> add element in priority queue ranked wise (In ascending order.)
 * remove() ---> O(log n) ---> By default Remove 1st element whose priority is high.
 * peek() ---> O(1) ---> peek higest priority element (1st element (front) in priority queue).
 * isEmpty() ---> Checek priority queue is empty or not. Return boolean value True or False.
 * 
 * PriorityQueue<DATA-TYPE> obj = new PriorityQueue<>(); ----> Store priority in ascending order.
 * PriorityQueue<DATA-TYPE> obj = new PriorityQueue<Comparator.reverseOrder()>(); ----> Store priority in descending order.
 */

import java.util.PriorityQueue;
import java.util.Comparator;

public class A_PriorityQueue_using_JCF {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Store priority in ascending order.
        
        pq.add(3); // O(log n)
        pq.add(4);
        pq.add(1);
        pq.add(7);
        
        System.out.print("Ascending order: ");
        while(!pq.isEmpty()) {
            System.out.print(pq.peek() + " "); // O(1)
            pq.remove(); // O(log n) ---> By default remove 1st (Highest priority)
        }
        System.out.println();
        
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder()); // Store priority in descending order.

        pq2.add(3); // O(log n)
        pq2.add(4);
        pq2.add(1);
        pq2.add(7);

        System.out.print("Reverse order: ");
        while(!pq2.isEmpty()) {
            System.out.print(pq2.peek() + " ");
            pq2.remove();
        }

    }
}
