import javax.naming.directory.SearchControls;

/*
 * Traversal in linked list
 * Print all data element's in linked list.
 */

public class C_TraversalInLinkedList {
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

    // print - O(n)
    public void print() { 
        Node temp = head;

        while(temp!= null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
        return;
    }
    public static void main(String[] args) {
        C_TraversalInLinkedList li = new C_TraversalInLinkedList();
        li.print();
        // add at first
        li.addFirst(2);
        li.print();
        
        li.addFirst(1);
        li.print();
        
        // add at last
        li.addLast(3);
        li.print();
        li.addLast(4);
        li.print();
    }
}
