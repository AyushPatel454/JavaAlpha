/*
 * ===> Doubly Linked List.
 */

public class F_DoublyLInkedList {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Add First
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        // If DBL is empty
        if(head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        return;
    }
    
    // Add Last
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        // If DBL is empty
        if(head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        return;
    }

    // Remove First
    public void removeFirst() {
        if(head == null) {
            System.out.println("Doubly linked list is empty.");
            return;
        }

        if(size == 1) {
            head = tail = null;
            size--;
            return;
        }

        head = head.next;
        head.prev = null;
        size--;
        return;
    }
    
    // Remove Last
    public void removeLast() {
        if(head == null) {
            System.out.println("Doubly linked list is empty.");
            return;
        }

        if(size == 1) {
            head = tail = null;
            size--;
            return;
        }

        tail = tail.prev;
        tail.next = null;
        size--;
        return;
    }

    // print
    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        F_DoublyLInkedList dbl = new F_DoublyLInkedList();

        // dbl.addFirst(3);
        // dbl.addFirst(2);
        // dbl.addFirst(1);

        dbl.addLast(1);
        dbl.addLast(2);
        dbl.addLast(3);
        dbl.addLast(4);

        dbl.print(); // 1 2 3 4
        System.out.println(size);
        
        dbl.removeFirst();
        dbl.print(); // 2 3 4
        System.out.println(size);
        
        dbl.removeLast();
        dbl.print(); // 2 3
        System.out.println(size);
    }
}
