/*
 * Question 5: Write a Java method to compute the sum
 * of the digits in an integer.
 */


import java.util.*;

public class q5 {
    public static int SumOfDigit(int a) {
        int  rem;
        int sum = 0;
        while(a >= 1) {
            rem = a%10;
            sum += rem;
            a /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter you num: ");
        int num = sc.nextInt();

        System.out.print("Sum of Digit is: "+SumOfDigit(num));
    }
}
