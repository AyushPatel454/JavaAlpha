import java.util.Scanner;

// ===> Print REVERSE of a number
// Example: 10899 ---> 99801 ; 123 ---> 321

public class reverse_number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number = ");
        int n = sc.nextInt();

        int last_digit , reverse = 0;

        while (n>=1) {
            last_digit = n%10;
            reverse = (reverse*10) + last_digit;
            n /= 10;     // ---> n = n / 10
        }
        System.out.println("Reverse = "+reverse);

        // ---> Another Method.
        // while (n>=1) {
        //     last_digit = n%10;
        //     System.out.print(last_digit);
        //     n /= 10;     // ---> n =n / 10
        // }

    }
}
