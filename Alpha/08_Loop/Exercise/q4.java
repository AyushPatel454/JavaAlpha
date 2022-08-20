import java.util.Scanner;

// Question4: Write a program to print the multiplication table of a number N,entered by the user.

public class q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number = ");
        int n = sc.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x "+ i + " = " + (n*i));
        }
    }
}
