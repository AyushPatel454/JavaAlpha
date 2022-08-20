// ===> Binomial Coefficient using functions.
// nCr = n!/(r!*(n-r)!)

import java.util.*;
public class BinomialCoefficient {

    // Calculate Factorial.
    public static int factorial(int a) {
        int ans = 1;
        for (int i = 1; i <= a; i++) {
            ans *= i;
        }
        return ans;
    }

    // Binomial Coefficient.
    public static int BinomialCoeff(int n,int r) {
        int fact_n = factorial(n); // n!
        int fact_r = factorial(r); // r!
        int fact_n_r = factorial(n-r); // n-r!

        int ans = fact_n/(fact_r*fact_n_r);
        
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n = ");
        int n = sc.nextInt();
        System.out.print("Enter r = ");
        int r = sc.nextInt();

        int ans = BinomialCoeff(n,r);

        System.out.println("Binomial Coefficient is: "+ans);
    }
}
