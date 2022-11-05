/* (Amazon , OYO)
 * ===> Stack using Linked List.
 */

import java.util.ArrayList;

public class B_StackUsingLinkedList {
    public static class Node {
        int data;
        Node next;
        // constructor.
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public static class Stack {
        static Node head = null; // Head = Top

        public static boolean isEmpty() {
            return head == null;
        }

        // push
        public static void push(int data) {
            Node newNode = new Node(data);

            if(isEmpty()) {
                head = newNode;
                return;
            }
            
            newNode.next = head;
            head = newNode;
            return;
        }
        
        // pop
        public static int pop() {
            if(isEmpty()) {
                System.out.println("Stack is Empty.");
                return -1;
            }
            
            int top = head.data;
            head = head.next;
            return top;
        }
        
        // peek
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Stack is Empty.");
                return -1;
            }
            
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        // push
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()) {
            System.out.println(s.peek()); // peek
            s.pop(); // pop
        }
        System.out.println("null");

        System.out.println(s.peek()); // stack is empty now. -1
    }
}