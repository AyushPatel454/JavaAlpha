/*
 * Question 2: Write a Java program to check if a number is
 * palindrome in Java?
 * ---> Ex: 121 is Palindrome.
 * ---> Ex: 123 is Not-Palindrome.
 * ---> Ex: 595 is Palindrome.
 * ---> Ex: 959 is Palindrome.
 */


import java.util.*;

public class q3 {
    public static boolean isPalindrome(int a) {
        int temp = a ; // copied number.
        int rem , rev = 0;

        while(a >= 1) {
            rem = a%10;
            rev = (rev*10) + rem;
            a /= 10;
        }
        if (rev == temp) {
            return true;
        }
        
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter you num: ");
        int num = sc.nextInt();

        System.out.println("Is Palindrome ?");
        System.out.println(isPalindrome(num));
    }
}
