/*
 * Time Complexity: O(n)
 * 
 * Question: 6: Valid Parenthesis.
 * 
 * Given a string S cantaining just the characters '(' , ')' , '{' , '}' , '[' and ']'.
 * Determine if the input string is valid.
 * 
 * An input string is  valid IF:
 *      1) Open brackets must be closed by the same type of brackets.
 *      2) Open brackets must be closed in the correct order.
 *      3) Every close bracket has a corresponding open bracket of the same type.
 * 
 * Example:
 * s = "()[]{}" ---> True
 * s = "()" ---> True
 * s = "(]" ---> False
 * s = ")(" ---> False
 */

import java.util.Stack;

public class I_ValidParenthesis {
    // valid parenthesis
    public static boolean  isValidParenthesis(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // opening
            if(ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            }
            else { // closing
                if(s.isEmpty()) {
                    return false;
                }
                // matching pair.
                if( (s.peek() == '(' && ch == ')') ||
                    (s.peek() == '{' && ch == '}') ||
                    (s.peek() == '[' && ch == ']') ) {
                        s.pop();
                }
                else {
                    return false;
                }
            }
        }

        if(s.isEmpty()) { // valid string
            return true;
        }
        else { // invalid string
            return false;
        }
    }

    public static void main(String[] args) {
        String str1 = "({[]}())";
        String str2 = "(({[]}())";
        String str3 = "({})[]";
        String str4 = ")()";

        System.out.println("\"({[]}())\": "+ isValidParenthesis(str1));
        System.out.println("\"(({[]}())\": "+ isValidParenthesis(str2));
        System.out.println("\"({})[]\": "+ isValidParenthesis(str3));
        System.out.println("\")()\": "+ isValidParenthesis(str4));
    }
}
