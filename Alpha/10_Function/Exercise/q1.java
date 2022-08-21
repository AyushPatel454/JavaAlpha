import java.util.Scanner;

// Question 1: Write a Java mehod to compute the average of theree numbers.

public class q1 {
    public static double avg(double a,double b,double c) {
        return (a+b+c)/3;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter num1: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter num2: ");
        double num2 = sc.nextDouble();
        System.out.print("Enter num3: ");
        double num3 = sc.nextDouble();

        System.out.println("Average = "+avg(num1, num2, num3));
    }
}