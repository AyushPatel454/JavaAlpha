/*
 * Question: 5: Interleave 2 Halves of a Queue. (Given Queue length is even.)
 * Time Complexity: O(n)
 * Space Complexity: O(n/2) = O(n)
 * 
 * Step 1: Create Queue object for store the 1st half of main queue.
 * Step 2: find the size of main queue.
 * Step 3: Store the 1st half of main queue in new queue. & at that time remove the 1st half from main queue.
 *         LOOP (0 to size/2):
 *              1stHalf.add(mainQueue.remove())
 * Step 4: remove front of new queue and add in mainQueue at last. &
 *         remove front of main queue and add in mainQueue at last.
 *         [Do this process until new queue become empty.]
 */

import java.util.*;

public class H_InterleaveTwoHalvesOfaQueue {
    
    //Inter leave queue.
    public static void interLeave(Queue<Integer> q) {
        // Storing 1st half of queue q.
        Queue<Integer> firstHalf = new LinkedList<>();
        // Find size of queue
        int size = q.size();

        // Store 1st half elements from queue q to firstHalf queue.
        for(int i=0; i<size/2; i++) {
            // Remove 1st half element from q. & Store that remove element in 1stHalf queue.
            firstHalf.add(q.remove());
        }

        // MAIN LOGIC.
        // Inter Leave.
        while(!firstHalf.isEmpty()) {
            // Remove front from 1stHalf & store that element in main queue q. at last.
            q.add(firstHalf.remove());
            // Remove front of main queue q & store that element in same queue (main queue q) at last.
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        // InterLeave Queue.
        interLeave(q);

        // Print InterLeave queue. (UPDATED q)
        while(!q.isEmpty()) {
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}
