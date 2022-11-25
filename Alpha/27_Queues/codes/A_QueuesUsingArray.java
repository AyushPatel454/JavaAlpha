/*
 * ===> Implementation of Queues Using Array.
 * 
 * Fixed size queue.
 * Time complexity of Remove operation = O(n)
 * We can create circular queue.
 */

public class A_QueuesUsingArray {

    public static class Queues {
        static int arr[];
        static int size;
        static int rear;

        // constructor
        Queues(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        // isEmpty
        public static boolean isEmpty() {
            return rear == -1;
        }

        // add ---> Time Complexity = O(1)
        public static void add(int n) {
            if(rear == size-1) {
                System.out.println("Queue is full...");
                return;
            }
            rear++;
            arr[rear] = n;
        }

        // remove ---> Time Complexity = O(n)
        public static int remove() {
            if(isEmpty()) {
                System.out.println("Queue is Empty...");
                return -1;
            }

            int front = arr[0];

            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i+1];
            }

            rear = rear - 1;

            return front;
        }

        // peek ---> Time Complexity = O(1)
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Queue is Empty...");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queues q = new Queues(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.peek());            
            q.remove();
        }

        q.remove();
    }
}
