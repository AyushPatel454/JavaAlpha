/*
 * Merge Sort in Linked list (Sorting in linked list)
 * (Same like Divde and Conquer method.)
 * Time Complexity: O(n log(n) )
 */

public class D_MergeSortInLL {
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
    
    // getMid
    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // Mid Node.
    }

    // merge ---> very important function
    private Node merge(Node head1,Node head2) {
        Node mergedLL = new Node(-1); // dummy node (Temporary node not for use. )
        Node temp = mergedLL;

        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next; // becuase 1st node of MergedLL is -1 (Dummy node)
    }

    // ===> mergeSort ---> Main function for merge sort
    public Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        // find mid
        Node mid = getMid(head);

        // left & right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft,newRight);
    }

    public static void main(String[] args) {
        D_MergeSortInLL ll = new D_MergeSortInLL();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);

        ll.print();

        head = ll.mergeSort(head);

        ll.print();
    }
}