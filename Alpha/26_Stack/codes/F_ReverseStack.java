/*
 * Question: 3: Reverse Stack.
 * Time Complexity: O(n) & Space Complexity: O(1)
 */

import java.util.*;

public class F_ReverseStack {
    // push at bottom
    public static void pushAtBottom(Stack<Integer> s,int data) {
        // base case
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
        return;
    }

    // reverse stack
    public static void reverseStack(Stack<Integer> s) {
        // base case
        if(s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
        return;
    }

    // print Stack
    public static void printStack(Stack<Integer> s) {
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    // main function
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);
        // 3 2 1

        reverseStack(s);
        printStack(s); // 1 2 3
    }
}
