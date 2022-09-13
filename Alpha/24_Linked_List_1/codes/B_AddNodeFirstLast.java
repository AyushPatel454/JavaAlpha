/*
 * Add Node at First and Last in Linked List.
 */

public class B_AddNodeFirstLast {
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
    // add Node First
    public void addFirst(int data) {
        // Step-1 = create new node
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            return;
        }
        // Step-2: newNode next = head
        newNode.next = head; // link
        // Step-3: head = newNode
        head = newNode;
    }
    
    // add Node Last
    public void addLast(int data) {
        // Step-1: Create newNode
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
        }
        // Step-2: tail.next = newNode
        tail.next = newNode;
        // Step-3: tail= newNode
        tail = newNode;
    }
    public static void main(String[] args) {
        B_AddNodeFirstLast li = new B_AddNodeFirstLast();
        li.addFirst(1);
        li.addFirst(2);

        li.addLast(3);
        li.addLast(4);
    }
}
