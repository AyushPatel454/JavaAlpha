/*
 * ===> Stack using Java Collection Framework.
 *          In intreview , contest use this method if there is no ask to implement using ArrayList or LinkedList.
 */

import java.util.Stack; // import Stack Class directly (Java Collection Framework)

public class C_StackUsingJCF {
    
    public static void main(String[] args) {
        // Stack s = new Stack(); // ---> single line change


        Stack<Integer> s = new Stack<>(); // same as Linked List JCF 

        // push
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()) {
            System.out.println(s.peek()); // peek
            s.pop(); // pop
        }
        System.out.println("null");
    }
}