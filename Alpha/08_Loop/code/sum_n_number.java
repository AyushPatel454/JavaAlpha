import java.util.Scanner;

import org.w3c.dom.css.Counter;

// ===> Print sum of first n natural numbers.

public class sum_n_number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter n = ");
        int n = sc.nextInt();

        int sum = 0, i = 1;

        while (i<=n) {
            sum += i; // sum = sum + i
            i++; // i = i + 1
        }

        System.out.println("Sum of n number = "+sum);
    }
}
