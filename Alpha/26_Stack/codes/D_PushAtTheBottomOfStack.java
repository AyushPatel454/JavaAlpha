/* (Amazon)
 * Question: 1: Push at the bottom of the stack.
 * Time Complexity: O(n) & Space Complexity: O(1)
 */

import java.util.*;

public class D_PushAtTheBottomOfStack {
    // Push at bottom
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
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottom(s , 4);

        while(!s.isEmpty()) {
            System.out.println(s.pop()); // 3 2 1 4
        }
    }
}
