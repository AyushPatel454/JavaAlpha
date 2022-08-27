/* (Company: Intuit)
 * Question: 1: Check if a string is a Palindrome.
 */

import java.util.Scanner;

public class b_palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        boolean flag = true;
        for (int i = 0; i < str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)) {
                // not a palindrome.
                flag = false;
                break;
            }
        }
        if(flag) {
            System.out.println("String is Palindrome.");
        }
        else {
            System.out.println("String is Not Palindrome.");
        }

    }
}
