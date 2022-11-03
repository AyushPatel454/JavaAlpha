/* ===> Remove Cycle in Linked List.
 * Question: 7
 *      Detect a Loop/Cycle in a Linked List & Remove Cycle in Linked List.
 * Time Complexity: O(n)
 */

public class B_RemoveCycleLL {

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

    // Remove Cycle
    public static void removeCycle() {
        // Detech cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // if slow & fast meet again.
            if(slow == fast) {
                System.out.println("Cycle is exist.");
                cycle = true;
                break;
            }
        }
        if(cycle == false) {
            System.out.println("Cycle is not exist.");
            return;
        }

        // find meeting point
        slow = head;
        Node prev = null; // previous of fast
        while(slow != fast) {
            prev = fast; // previous of fast.
            slow = slow.next; // +1
            fast = fast.next; // +1
        }

        // Corner case: Not requrie in coding conteset. they not ask this case. Ask only in between cycle not head.
        if(prev == null) { // slow = fast = head. (last node is coonect with head)// Reverse liked list like that: 1->2->3->1 
            while(fast.next != head) {
                fast = fast.next;
            }
            fast.next = null;
            return;
        }

        // remove cycle ---> last.next = null;
        prev.next = null;
    }

    // Check cycle
    public static boolean isCycle() { // we can direct call without ll.isCycle() because it is static function. So call ---> isCycle();
        Node slow = head;
        Node fast = head;
        // move slow ---> +1 & fast ---> +2
        while(fast != null && fast.next != null) {
            slow = slow.next;       // +1
            fast = fast.next.next;  // +2
            // check slow & fast same node ?
            if(slow == fast) {
                return true; // cycle is exist.
            }
        }
        return false; // cycle is not exist.
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
        B_RemoveCycleLL ll = new B_RemoveCycleLL();

        // add nodes
        head = new Node(1); // Head = 1
        head.next = new Node(2); // 1.next = 2
        head.next.next = new Node(3); // 2.next = 3
        head.next.next.next = head.next;
        // 1->2->3-> 1-> ... ... ...

        System.out.println(isCycle()); // check cycle exist or not.

        // remove cycle
        removeCycle();

        System.out.println(isCycle()); // check cycle exist or not.

        // print
        ll.print();
    }
}