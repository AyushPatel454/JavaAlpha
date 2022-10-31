/*
* Question: 2:
*           Search for a key in a Liked List. Return the position where it is found. If not found, return -1.
*           Use Recursion.
* Time Complexity: O(n)
* Space Complexity: O(n)
*/

import java.util.Scanner;

public class I_SearchRecursion {
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

    // SEARCH (Recursivie) Node.
    public int recSearch(Node head,int target) {
        // Base case
        if(head.data == target) {
            return 0;
        }
        else if(head.next == null) {
            return -1;
        }
        
        head = head.next;
        int idx = recSearch(head, target);
        if(idx == -1) {
            return -1;
        }

        return idx+1;
    }

    public static void main(String[] args) {
        I_SearchRecursion li = new I_SearchRecursion();
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
        int ans = li.recSearch(head,target);
        
        // if target is not found...
        if(ans == -1) {
            System.out.println("Target "+target+" is not Found...!!");
            return;
        }

        System.out.println("Target "+target+" is found at index no: "+ans);
        System.out.println("Head: "+head.data+"  Tail: "+tail.data);
    }
}
