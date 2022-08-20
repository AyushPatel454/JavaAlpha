import java.util.Scanner;

/*
Question2: Write a program that reads a set of integers,
and then prints the sum of the even and odd integers.
 */

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many number you want insert: ");
        int n = sc.nextInt();

        int input,even_sum = 0,odd_sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter num = ");
            input = sc.nextInt();

            if(input%2 == 0) {
                even_sum += input; //even_sum = even_sum + input
            }
            else {
                odd_sum += input; //odd_sum = odd_sum + input
            }
        }

        System.out.println("Answer...");
        System.out.println("Sum of Even number: "+even_sum);
        System.out.println("Sum of Odd number: "+odd_sum);
    }
}
