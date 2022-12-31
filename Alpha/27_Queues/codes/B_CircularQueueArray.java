/*
 * ===>Circular Queue using Array.
 */

public class B_CircularQueueArray {
    public static class Queues {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        // constructor
        Queues(int n) {
            arr = new int[n];
            size = n;
            front = -1;
            rear = -1;
        }

        // isEmpty
        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        // isFull
        public static boolean isFull() {
            return (rear+1)%size == front;
        }

        // add ---> Time Complexity = O(1)
        public static void add(int n) {
            if(isFull()) {
                System.out.println("Queue is full...");
                return;
            }
            // add 1st time
            if(front == -1) {
                front = 0;
            }

            rear = (rear+1)%size;
            arr[rear] = n;
        }

        // remove ---> Time Complexity = O(n)
        public static int remove() {
            if(isEmpty()) {
                System.out.println("Queue is Empty...");
                return -1;
            }

            int result = arr[front];

            if(rear == front) {
                rear = front = -1;
            }
            else {
                front = (front + 1) % size;
            }

            return result;
        }

        // peek ---> Time Complexity = O(1)
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Queue is Empty...");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queues q = new Queues(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        q.remove();
        q.remove();
        q.remove();
        q.add(6);
        q.add(7);
        
        while (!q.isEmpty()) {
            System.out.println(q.peek());            
            q.remove();
        }

        q.remove();
    }
}
