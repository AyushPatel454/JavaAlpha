import java.util.Stack;

/* Company: Microsoft, Google.
 * Question: 2: Queue using 2 stack.
 * Method 1: PUSH - O(n) & Pop - O(1) 
 * Method 2: Pop - O(n)  & PUSH - O(1)
 * 
 * We use method 1
 */

public class E_QueueUsingTwoStack {
    public static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // add - O(n)
        public static void add(int data) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // remove
        public static int remove() {
            if(s1.isEmpty()) {
                System.out.println("Queue is Empty...!!");
                return -1;
            }
            return s1.pop();
        }

        // peek
        public static int peek() {
            if(s1.isEmpty()) {
                System.out.println("Queue is Empty...!!");
                return -1;
            }
            return s1.peek();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.remove();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
