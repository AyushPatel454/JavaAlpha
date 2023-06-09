/*
 * ===> Question: 1: Fibonacci.
 * 
 * With simple Recursion & Dynamic Programming.
 * 
 * fib(n) = fib(n-1) + fib(n-2)
 * 
 * In Dynamic Programming we calculate value only once & store in some where (array) & when we want to calculate again then we retrive value from array so we no need to
 * calculate value again.
 * 
 * ---> Ways of DP:-
 *  i) Memoization: (Top Down)
 *          Recursion
 *          Subproblem ---store---> Storage (Array) ------> Reuse
 *  ii) Tabulation: (Bottom Up)
 *          Iteration - Loop
 *          table / set / storage
 *          Step 1: Initialization Storage (Array)
 *          Step 2: Assign Meaning (In your mind :) )
 *          Step 3: Filling Storage (small problem solution ---to---> Large problem solution)
 * 
 * _______________________________________________________________________________________________________
 *                    -:Time Complexity:-
 *      Simple Recursion: Time Complexity = O(2^n)
 * 
 *                  -:Dynamic Programming:- 
 *          Memoization: Time Complexity = O(n)
 *          Tabulation: Time Complexity = O(n)
 */

public class A_Fibonacci {
    // ---> Simple Recursion
    public static int fibSimple(int n) { // Time Complexity = (2^n)
        if(n == 0 || n == 1) {
            return n;
        }

        return fibSimple(n - 1) + fibSimple(n - 2);
    }

    // ---> Dynamic Programing Approach:-
    // -----> Memoization (Recursion)
    public static int fibMemoization(int n, int dp[]) { // Time Complexity = O(n)
        if( n == 0 || n == 1) {
            return n;
        }

        if(dp[n] != 0) { // fib(n) already calculated.
            return dp[n];
        }

        // fib(n) not calculated then calculate.
        dp[n] = fibMemoization(n - 1, dp) + fibMemoization(n - 2, dp);
        
        return dp[n];
    }

    // -----> Tabulation (Iteratoin - loop)
    public static int fibTabulation(int n) { // Time Complexity = O(n)
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 6;
        System.out.println("Simple Recursion: " + fibSimple(n));

        int dp[] = new int[n+1]; // n+1  because we calculate for n & it's value store in n+1 index

        System.out.println("DP Recursion Memoization: "+fibMemoization(n, dp));
        System.out.println("DP Recursion Tabulation: "+fibTabulation(n));
    }
}
