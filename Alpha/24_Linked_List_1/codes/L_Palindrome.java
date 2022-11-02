/*
* Question: 5
 *          Check if Linked List is a Palindrome.
 * Time Complexity: O(n)
 */

import java.util.Scanner;

public class L_Palindrome {

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

    // Find mid - (SLOW - FAST Approach) ---> Helper function
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) { // (fast.next != null && fast != null) ---> it gives error. Because, if fast is null then we check condtions. So 1st condition is [fast.next != null] which is wrong because fast is null so fast.next ????
            slow = slow.next;       // +1
            fast = fast.next.next;  // +2
        }
        // Now, Slow is set at mid position in linked list.
        return slow; // slow is my MID-NODE.
    }

    // Palindrome
    public boolean isPalindrome() {
        // base case
        if(head == null || head.next == null) {
            return true;
        }

        // Step - 1: Find mid node.
        Node midNode = findMid(head);

        // Step - 2: Reverse 2nd half.
        Node prev = null;
        Node curr = midNode;
        Node next;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step - 3: Check 1st half == 2nd half
        Node left = head; // 1st half head
        Node right = prev; // 2nd hlaf head
        
        while(right != null) {
            if(left.data != right.data) {
                System.out.println("Is not palindrome.");
                return false;
            }
            left = left.next;
            right = right.next;
        }
        System.out.println("Is palindrome.");
        return true;
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
        L_Palindrome ll = new L_Palindrome();

        // add nodes
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(2);
        ll.add(1);

        System.out.println("Linked list: ");
        // print
        ll.print(); // 1 -> 2 -> 3 -> 2 -> 1 -> null
        
        // Check palindrom.
        ll.isPalindrome();

        System.out.println("Head: "+head.data+"\tTail: "+tail.data);
    }
}
