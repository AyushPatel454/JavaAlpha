/*
 * Question: 6: Queue Reversal.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Hint: Using STACK data structure.
 *       Because STACK have special property to reverse element.
 *       1, 2, 3 ----PUSH----> |    | ---POP---> 3, 2, 1
 *                             | 3  |
 *                             | 2  |
 *                             | 1  |
 *                             -----
 * 
 * Step 1: Create objec of Stack Class.
 * Step 2: Remove all element of Queue and PUSH in Stack object.
 * Step 3: POP all element of Stack object and add in Queue.
 */

import java.util.*;

public class I_QueueReversal {
    
    // Reverese Queue.
    public static void reversealQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();

        // Push all element of Queue in stack.
        while(!q.isEmpty()) {
            // Remove front of queue and push in stack.
            s.push(q.remove());
        }

        // Pop all element in stack & store in Queue back.
        while(!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        // Reverse Queue.
        reversealQueue(q);

        // Print Q.
        while(!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
