/* ===> Cycle in Linked List.
 * Question: 6
 *      Detect a Loop/Cycle in a Linked List.
 * Time Complexity: O(n)
 */

public class A_LoopCycleLL {

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

    // Check Cycle ---> Floyd's Cycle Finding Algorithm.
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
        A_LoopCycleLL ll = new A_LoopCycleLL();

        // add nodes
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head;
        // 1->2->3->4->1

        // print
        // ll.print(); // 1 -> 2 -> 3 -> 4 -> 1 -> 2 -> 3 -> 4 -> 1 -> 2 -> 3 -> 4 -> REPEAT LINKED LIST AGAIN AND AGAIN...

        // Check Cycle
        System.out.println("There is a Cycle. ---> "+isCycle());
    }
}