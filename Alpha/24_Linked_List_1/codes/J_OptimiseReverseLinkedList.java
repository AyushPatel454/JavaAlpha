/*
 * Reverse Linked List
 * Time Complexity: O(n)
 */

public class J_OptimiseReverseLinkedList {
    class Node{
        int data;
        Node next;
        // constructor
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // add last
    public void add(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    // reverse linked list
    public void reverseLL() {
        Node prev = null;
        Node curr = tail = head; // curr = head & tail = head
        Node next; // INILIZE in LOOP.

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // set head
        head = prev;
    }

    // print
    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        J_OptimiseReverseLinkedList ll = new J_OptimiseReverseLinkedList();

        // add nodes
        for (int i = 0; i < 10; i++) {
            ll.add(i+1);
        }

        System.out.println("Linked list: ");
        // print
        ll.print();

        // reverse linked list
        ll.reverseLL();


        System.out.println("Reverse Linked list: ");
        // print
        ll.print();

        System.out.println("Head.data: "+head.data+"\tHead.next.data: "+head.next.data+"\tTail: "+tail.data);
    }
}
