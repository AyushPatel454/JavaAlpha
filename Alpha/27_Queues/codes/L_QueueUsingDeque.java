/*
 * Question: 7: Stack and Queue using Deque.
 * 
 * Operations : Used Method of Deque : Time Complexity
 * Add    :    addLast()   : O(1)
 * Remove :  removeFirst() : O(1)
 * peek   :   getFirst()   : O(1)
 */

 import java.util.*;

 public class L_QueueUsingDeque {
     static class Queue{
         static Deque<Integer> deque = new LinkedList<>();

         // add
         public static void add(int data) {
             deque.addLast(data);
         }
 
         // remove
         public static int remove() {
             return deque.removeFirst();
         }
 
         // peek
         public static int peek() {
             return deque.getFirst();
         }
     }
 
     public static void main(String[] args) {
         Queue q = new Queue();
 
         q.add(1);
         q.add(2);
         q.add(3);
 
         System.out.println("Peek = "+q.peek());
         System.out.println(q.remove());
         System.out.println(q.remove());
         System.out.println(q.remove());
     }
 }
 