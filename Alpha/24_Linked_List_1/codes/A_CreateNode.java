/*
 * Creating Node
 */

public class A_CreateNode {
    // class
    public static class Node {
        int data;
        Node next;
        // constructor
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Creating head & tail (In linked list there is only one head and one tail)
    public static Node head; // Head
    public static Node tail; // Tail

    // Methods
    // add()   // add Node in linked list
    // remove()   // remove node in linke list
    // print()   // print linked list
    // search()   // search node in linked list

    public static void main(String[] args) {
        A_CreateNode ll = new A_CreateNode();
        ll.head = new Node(1);
        ll.head.next = new Node(2);
    }
}
