import java.util.Scanner;

// Question1: Write a Java program to get a number from the user and print whether it is positive or negative.

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if (num>0) {
            System.out.println("Number is +ve.");
        }
        else if(num == 0) {
            System.out.println("Number is 0.");
        }
        else {
            System.out.println("Number is -ve.");
        }
    }    
}