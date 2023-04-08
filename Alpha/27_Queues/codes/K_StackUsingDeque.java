/*
 * Question: 7: Stack and Queue using Deque.
 * 
 * Operations : Used Method of Deque : Time Complexity
 * push :   addLast()  : O(1)
 * pop  : removeLast() : O(1)
 * peek :  getLast()   : O(1)
 */

import java.util.*;

public class K_StackUsingDeque {
    static class Stack{
        static Deque<Integer> deque = new LinkedList<>();

        // push
        public static void push(int data) {
            deque.addLast(data);
        }

        // pop
        public static int pop() {
            return deque.removeLast();
        }

        // peek
        public static int peek() {
            return deque.getLast();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("Peek = "+s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
