/*
 * Time Complexity: O(n)
 * 
 * Question: 7: Duplicate Parentheses.
 * 
 * Given a balanced expression, find if it contains duplicate parentheses or not.
 * A set of parentheses are duplicate IF the same subexpression is surrounded by multiple parentheses.
 * 
 * Return TRUE if it contains Duplicates.
 * Return FALSE if it contains NO-Duplicates.
 * 
 * Example:
 * ( ( (a+(b)) ) + (c+d)) ---> True (Duplicate exist.)
 * ( ( ( (a) + (b) ) + c + d ) ) ---> True (Duplicate exist.)
 * ((a + b) + (c + d)) ---> False
 * (((a + b)) + c) ---> True (Duplicate exist.)
 */

import java.util.Stack;

public class J_DuplicateParenthesis {
    // Duplicate Parenthesis.
    public static boolean isDuplicate(String str) { // O(n)
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            // Closing
            if(ch == ')') {
                int count = 0;

                while(s.peek() != '(') {
                    count++;
                    s.pop();
                }

                if(count < 1) {
                    return true; // Duplicate
                } else {
                    s.pop(); // opening pair
                }

            } else {
                // opening
                s.push(ch);
            }
        }

        return false;
    }
    public static void main(String[] args) {
        String str1 = "(a+b)"; // False (No-Duplicate)
        String str2 = "((a+b))"; // True (Duplicate)

        System.out.println("\"(a+b)\": "+isDuplicate(str1));
        System.out.println("\"((a+b))\": "+isDuplicate(str2));
    }
}
