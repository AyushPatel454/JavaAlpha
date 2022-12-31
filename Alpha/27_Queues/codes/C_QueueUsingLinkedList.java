/* Company: Microsoft
 * Question: 1: Queue using Linked List
 * Time complexity: O(1)
 */

public class C_QueueUsingLinkedList {
    // Node Class
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head = null;
    public static Node tail = null;

    // Queue Class
    public static class Queue {
        static int rear;
        static int front;

        // constructor
        Queue() {
            front = -1;
            rear = -1;
        }

        // isEmpty
        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // add ---> Time Complexity = O(1)
        public static void add(int n) {
            Node newNode = new Node(n);

            if(head == null) {
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        // remove ---> Time Complexity = O(1)
        public static int remove() {
            if(isEmpty()) {
                System.out.println("Queue is Empty...");
                return -1;
            }

            int front = head.data;

            if(tail == head) {
                tail = head = null;
                return -1;
            }
            else {
                head = head.next;
            }
            return front;
        }

        // peek ---> Time Complexity = O(1)
        public static int peek() {
            if(head == null) {
                System.out.println("Queue is Empty...");
                return -1;
            }

            return head.data;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.remove();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println("Remove head: "+q.remove());
        
        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
