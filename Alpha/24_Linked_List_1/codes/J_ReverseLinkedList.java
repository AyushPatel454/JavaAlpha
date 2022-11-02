/*
* Question: 3: (Important Question & Classical Question)
*           Reverse Liked List. ----------------> Key point: create new temporary linked list.
* Time Complexity: O(n^2)
* ------------------------------------------------------------
* Example:  
* H              T
* 1 -> 2 -> 3 -> 4
*
* ---------------FUNCTION CALL OPERATION---------------------
*
* H         DP  P,T  =======>  H,P        DP,T   NH,NT
* 1 -> 2 -> 3 -> 4   =======>  1   -> 2 ->  3  -> 4
*
* H   DP    P,T  NH,NT  =======>  H,P   DP,T   NH   NT
* 1 -> 2 ->  3 ->  4    =======>  1   -> 2 ->  4  -> 3
*
* H,DP   P,T   NH   NT  =======>  H,T,DP   NH         NT
* 1   -> 2 ->  4  -> 3  =======>    1   -> 4 ->  3  -> 2
*
* H,T,DP,P   NH         NT  =======>    NH              NT
*     1   -> 4 ->  3  -> 2  =======>    4 ->  3  -> 2 -> 1
* ------------------------------------------------------------
*                       NH              NT
*                       4 ->  3  -> 2 -> 1
* ------------------------------------------------------------
*                       H = NH   ,     T = NT
* ------------------------------------------------------------
*                       H,NH            T,NT
*                       4 ->  3  -> 2 -> 1
* ------------------------------------------------------------
*/

/**
 * J_ReverseLinkedList
 */

public class J_ReverseLinkedList {
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

    // creating new temporary linked list (for Reverse linked list)
    public static Node newHead;
    public static Node newTail;

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
        Node prev = head;
        Node delPrev = prev;

        for (int i = 0; i < size; i++) {
            // take previous node to tail
            while(prev != tail) {
                delPrev = prev;
                prev = prev.next;
            }

            // now, tail = prev both are same.
            // With help of tail data create new node.
            // Then delete tail node.
            // Then set tail = delete previous.
            int value = prev.data;
            Node newNode = new Node(value);

            // if newHead = newTail = null...
            if(newHead == null) {
                newHead = newTail = newNode;
                tail = delPrev;
                delPrev.next = newHead;
            }
            // if only one node is left in orignal linked list. &
            // that time ...
            // Head = Tail = DeletePrevious = Previous
            else if(head == tail) {
                newTail.next = newNode;
                newTail = newNode;
                tail.next = null;
                break;
            }
            else {
                // create link from new tail to new node.
                newTail.next = newNode;
                // set new tail to new node.
                newTail = newNode;
                // create link from deletePrevious to newHead
                delPrev.next = newHead;
                // delete tail node.
                tail.next = null;
                // set tail to delete previous node.
                tail = delPrev;
            }

            prev = head;
        }

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
        J_ReverseLinkedList ll = new J_ReverseLinkedList();

        // add nodes
        for (int i = 0; i < 10; i++) {
            ll.add(i+1);
        }

        System.out.println("Linked list: ");
        // print
        ll.print();

        // reverse linked list
        ll.reverseLL();

        // set head & tail
        head = newHead;
        tail = newTail;

        System.out.println("Reverse Linked list: ");
        // print
        ll.print();

        System.out.println("Head.data: "+head.data+"\tHead.next.data: "+head.next.data);
    }

    public void reverseLL(J_OptimiseReverseLinkedList.Node head2) {
    }
}