/* (Microsoft, Flipkart, Adobe, Paytm)
* Question: 2: Reverse String using stack.
* 
* Time Complexity: O(n) & Space Complexity: O(1)
*/

import java.util.*;

public class E_ReverseStringUsingStack {
    // Reverse string
    public static String reveresString(String str) {
        Stack<Character> s = new Stack<>();
        
        int idx = 0;
        while(idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }

        return result.toString(); // convert string builder to string
    }
    

    public static void main(String[] args) {
        String str = "abc";

        String result = reveresString(str);

        System.out.println(result); // cba
    }
}
