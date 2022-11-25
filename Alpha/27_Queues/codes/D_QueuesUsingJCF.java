/*
 * ===> Queue using Java Collection Frame-work. (JCF)
 */

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class D_QueuesUsingJCF {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(); // Here Queue is interface that's way we wirte right side LinkedList<>()
                                               // We can't create object of Queue. because it is interface.
                                               // also use ---> ArrayDeque
        // Queue<Integer> q = new ArrayDeque<>();     // same ad LinkedList<>();                                          
        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
