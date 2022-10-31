public class F_ReomveLinkedList {
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

    // add Middle
    public void addMiddle(int idx,int data) {
        if(idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;

        while(i < idx-1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    // Remove first node
    public void removeFirst() {
        // If Linked List is empty.
        if(size == 0) {
            System.out.println("Linked list is empty.");
            return;
        }
        // If only one node in linked list. then HEAD = TAIL = NULL
        else if(size == 1) {
            head = tail = null;
            size--;
            return;
        }
        head = head.next;
        size--;

        return;
    }

    // Remove last node
    public void removeLast() {
        // If Linked List is empty.
        if(size == 0) {
            System.out.println("Linked list is empty.");
            return;
        }
        // If only one node in linked list. then HEAD = TAIL = NULL
        else if(size == 1) {
            head = tail = null;
            size--;
            return;
        }

        // Previous : i = size - 2
        Node previous;
        int i;
        previous = head;

        // Apna college method
        // for (int j = 0; j < size-2; j++) {
        //     prev = prev.next;
        // }

        while (previous.next != tail) {
            previous = previous.next;
        }

        previous.next = null;
        tail = previous;
        size--;

        return;
    }

    // Remove middle
    public void removeMiddle(int idx) {
        // If Linked List is empty.
        if(size == 0) {
            System.out.println("Linked list is empty.");
            return;
        }
        else if(idx>=size) {
            System.out.println("Index node is not availabe right now.");
            return;
        }

        // If Remove first node.
        if(idx == 0) {
            removeFirst();
            return;
        }

        Node temp;
        int i=0;
        temp = head;

        while(i<idx-1) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        size--;

        return;
    }

    // Print
    public void print() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null\t, Size: "+size);
        return;
    }

    public static void main(String[] args) {
        F_ReomveLinkedList li = new F_ReomveLinkedList();
        
        // Add Last
        li.addLast(1);
        li.addLast(2);
        li.addLast(3);
        li.addLast(4);
        li.print();

        // Remove First
        li.removeFirst();
        li.print();

        // Remove Last
        li.removeLast();
        li.print();

        // Remove Middle
        li.removeMiddle(2);
        li.print();

        System.out.println("Head: "+li.head.data+"\tTail: "+li.tail.data);
        System.out.println("Head->Next.data: "+li.head.next.data);
    }
}
