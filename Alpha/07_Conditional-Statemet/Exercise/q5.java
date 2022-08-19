import java.util.Scanner;

/*
 * Question5: Write a Java program that takes a year from 
 * the user and print whether that year is a leap year or 
 * not.
 */

public class q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        if((year%4 == 0) && (year%100 != 0) || (year%400 == 0)) {
            // Operator Precedence.
            // Logical AND &&  is larger than Logical OR || 
            // && > || 
            // year%4 && year%100 Evaluate 1st and give ---> ans1
            // after. Ans1 || year%400 evaluate and give --->ANSWER
            System.out.println(year+" is Leap Year.");
        }
        else {
            System.out.println(year+" is Not Leap Year.");
        }
    }
}
