/*
* Question: 1:
*           Search for a in a Linked List. Return the position where it is found. If not found then, return -1 .
* Time Complexity: O(n)
*/

import java.util.Scanner;

public class H_SearchIterative {
    public class Node {
        int data;
        Node next;
        // Constructor
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;
    
    // Adding node.
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

    // Display Liked List.
    public void print() {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // SEARCH (Iterative) Node.
    public int search(int target) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if(temp.data == target) {
                return i;
            }
            else {
                temp = temp.next;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        H_SearchIterative li = new H_SearchIterative();
        Scanner sc = new Scanner(System.in);

        // Create Linked List
        for (int i = 0; i < 10; i++) {
            li.add(i+1);
        }

        // Display Linked List
        li.print();

        // Take user targert
        System.out.print("Enter your target: ");
        int target = sc.nextInt();
        int ans = li.search(target);

        // if target is not found...
        if(ans == -1) {
            System.out.println("Target "+target+" is not Found...!!");
            return;
        }

        System.out.println("Target "+target+" is found at index no: "+ans);
    }
}
