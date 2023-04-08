/*
 * ===> Deque. (Double Ended Queue.)
 * 
 *      In Deque we perform operation add and remove from both the side (array.)
 *      
 *      Deque is Java Collections Framework (JCF). We can implement Deque using JCF.
 *      import java.util.*;
 * 
 *      There is mainly 6 important method of Deque.
 *         i) addFirst()
 *        ii) addLast()
 *       iii) removeFirst()
 *        iv) removeLast()
 *         v) getFirst()
 *        vi) getLast()
 */


import java.util.*;

public class J_Deque {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);

        System.out.println("Add Elements:"+deque);
        
        deque.removeFirst();
        deque.removeLast();
        System.out.println("Remove Element:"+deque);

        System.out.println("getFirst: "+ deque.getFirst());
        System.out.println("getLast: "+ deque.getLast());
    }
}
