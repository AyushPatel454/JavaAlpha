/*
 * ===> Stack using ArrayList
 */

import java.util.ArrayList;

public class A_StackUsingArrayList {
    public static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // push
        public static void push(int data) {
            list.add(data); // add at last
        }

        // pop
        public static int pop() {
            // If stack is already empty
            if(isEmpty()) {
                return -1;
            }
            int top = list.get(list.size()-1);
            
            list.remove(list.size()-1);
            return top;
        }
        
        // peek
        public static int peek() {
            // If stack is already empty
            if(isEmpty()) {
                return -1;
            }
            return list.get(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        // push
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println("List: "+s.list);

        while(!s.isEmpty()) {
            System.out.println(s.peek()); // peek
            s.pop(); // pop
        }
    }
}