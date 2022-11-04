/*
 * Zig-Zag linked list.
 */

public class E_ZigZagLinkedList {
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

    public static Node head; // Head
    public static Node tail; // Tail
    public static int size; // Size

    // add first
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    // add Last
    public void addLast(int data) {
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

    // Print
    public void print() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        
        System.out.println("null , \tSize: "+size);
        return;
    }
    
    // Zig-Zag Linked List
    public void zigZagLL() {
        // find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;

        // Reverse 2nd half
        Node curr = mid.next;
        mid.next = null; // left side is scuccesfull separate.
        Node prev = null;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Alternate marging
        Node left = head; 
        Node right = prev;
        Node nextLeft,nextRight;

        while(left != null && right != null) {
            nextLeft = left.next;
            left.next = right;
            nextRight = right.next;
            right.next = nextLeft;

            // update
            left = nextLeft;
            right = nextRight;
        }

    }    

    public static void main(String[] args) {
        E_ZigZagLinkedList ll = new E_ZigZagLinkedList();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        ll.print();

        ll.zigZagLL();

        ll.print();
    }
}