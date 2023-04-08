import java.util.*;
/* Company: InTuTT, Microsoft, Google.
 * Question: 3: Stack using 2 Queue.
 * Method 1: PUSH - O(n) & Pop - O(1) 
 *  
 * Method 2: Pop - O(n)  & PUSH - O(1)
 * Explenation ---> Take 2 queue q1 & q2.
 *             ---> (Add value in q1 or q2) : (Because there is possiblity to element present only q1 or q2.)
 *             --->   i) Add all element in which all element are present q1 or q1. (If both empey then add in q2.)
 *             --->  ii) For remove top of Stack.
 *                       ---> remove Front of q1 or q2 (in which all element are preset.) & Add in other queue (in empty queue. q1 or q2.)
 *                       ---> take last element of queue (which is our top of stack) and return. Not add in other queue q1 or q2.
 * 
 *             ---> Add new element in stack element After remove element. (Follow same prochedure.) (Add element in which where queue q1 or q2 is not empty.)
 * 
 * We use method 2
 */

public class F_StackUsingTwoQueue {
    public static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }
        
        // add - O(1)
        public static void push(int data) {
            if(!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        // remove - O(n)
        public static int pop() {
            if(isEmpty()) {
                System.out.println("Empty Stack...!!");
                return -1;
            }
            int top = -1;

            // case 1 ---> Q1 is not emepty. : All element present in Q1.
            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    top = q1.remove(); // store top value.
                    if(q1.isEmpty()) { // if last element then return. Not add into second queue.
                        break;
                    }
                    q2.add(top);
                }
            } else { // case 2 ---> Q2 is not emepty. : All element present in Q2.
                while(!q2.isEmpty()) {
                    top = q2.remove(); // store top value.
                    if(q2.isEmpty()) { // if last element then return. Not add into second queue.
                        break;
                    }
                    q1.add(top);
                }
            }

            return top;
        }

        // peek - O(n)
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Empty Stack...!!");
                return -1;
            }
            int top = -1;

            // case 1 ---> Q1 is not emepty. : All element present in Q1.
            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    top = q1.remove(); // store top value.
                    q2.add(top);
                }
            } else { // case 2 ---> Q2 is not emepty. : All element present in Q2.
                while(!q2.isEmpty()) {
                    top = q2.remove(); // store top value.
                    q1.add(top);
                }
            }

            return top;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.pop();
        s.peek();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
