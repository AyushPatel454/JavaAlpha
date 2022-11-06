/* ===> Next Greater Right
 * Question: 5: Next Greater Right.
 * The next greater element of some element X in an array is the FIRST GREATER element that is to the RIGHT OF X in the same array.
 * Time Complexity: O(n)
 * 
 * Example: 
 * arr = [6,8,0,1,3]
 * NextGreaterRight = [8,-1,1,3,-1]
 * 
 * Other Questions like this:
 *      Next Greater Right
 *      Next Greater Left
 *      Next Smaller Right
 *      Next Smaller Left
 */

import java.util.Stack;

public class H_NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        Stack<Integer> s = new Stack<>();
        int nxtGreater[] = new int[arr.length];

        // Next Greater Right.
        for (int i = arr.length-1 ; i >= 0; i--) {
            // 1 While
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // 2 if-else
            if(s.isEmpty()) {
                nxtGreater[i] = -1;
            } else {
                nxtGreater[i] = arr[s.peek()];
            }

            // 3 push
            s.push(i);
        }

        // Print nextGreater Right array.
        for (int i = 0; i < nxtGreater.length; i++) {
            System.out.print(nxtGreater[i] + " ");
        }
        System.out.println();
    }
}
