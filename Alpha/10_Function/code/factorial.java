// ===> Find Factorial of a number, n

import java.util.*;

public class factorial {

    // Calculate Factorial function.
    public static int factorial(int a) {
        int ans = 1;
        for (int i = 1; i <= a; i++) {
            ans *= i;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter num = ");
        int n = sc.nextInt();

        System.out.println(n + "! = " + factorial(n));
    }
}
