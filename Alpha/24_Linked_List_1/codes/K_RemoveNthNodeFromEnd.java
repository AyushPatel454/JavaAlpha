/*
* Question: 4 (Iterative Approach)
 *          Find & Remove Nth node from End.
 * Time Complexity: O(n)
 */

import java.util.Scanner;

public class K_RemoveNthNodeFromEnd {

    public static class Node{
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

    // Remove Nth node from End.
    public void removeNthNodeEnd(int n) {
        Node curr = head;

        if(n == size) {
            System.out.println("Last "+n+"th node data: "+head.data);
            head = head.next;
            size--;
            return;
        }
        else if(n > size) {
            System.out.println("Node is not availabel. Only "+size+" Nodes are exists.");
            return;
        }

        for (int i = 0; i < size-n-1; i++) {
            curr = curr.next;
        }
        
        System.out.println("Last "+n+"th node data: "+curr.next.data);

        curr.next = curr.next.next;
        size--;

        // if n = 1. Then we change tail position also.
        if(n == 1) {
            tail = curr;
        }
        
        return;
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
        Scanner sc = new Scanner(System.in);
        K_RemoveNthNodeFromEnd ll = new K_RemoveNthNodeFromEnd();

        // add nodes
        for (int i = 0; i < 6; i++) {
            ll.add(i+1);
        }

        System.out.println("Linked list: ");
        // print
        ll.print();

        // take input
        System.out.print("Enter n from End. n = ");
        int n = sc.nextInt();
        
        // Delete Nth node from last
        ll.removeNthNodeEnd(n);
        // print
        System.out.println("After deleteing: ");
        ll.print();

        System.out.println("Head: "+head.data+"\tTail: "+tail.data);
    }
}
