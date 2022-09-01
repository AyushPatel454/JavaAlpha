/*
 * Problem: 3: Print Factorial of number n. (Decreasing Order.)
 */

public class C_Factorial {
    // Own method.
    static int ans;
    public static int fact(int n) {
        if(n == 0) { // Base case ---> jena mate apane khabar hoy answer su hase & tya thi apde return thava nu che.
            ans = 1;
            return ans; // return if n = 0!
        }
        fact(n-1);
        ans = n * ans;
        return ans;
    }

    // Another method (Apna college)
    public static int factorial(int n) {
        if(n == 0) {
            return 1;
        }
        int fnm1 = fact(n-1);
        int fn = n * fact(n-1); // int fn = n * fnm1
        return fn;
    }
    public static void main(String[] args) {
        System.out.println(fact(5)); // own method
        System.out.println(factorial(6)); // apna college
    }
 }