import java.util.Scanner;

// ===> Check number is ODD or EVEN.

public class odd_even {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if(num%2 == 0) {
            System.out.println(num+" is Even number.");
        }
        else {
            System.out.println(num+" is Odd number.");
        }
    }
}
