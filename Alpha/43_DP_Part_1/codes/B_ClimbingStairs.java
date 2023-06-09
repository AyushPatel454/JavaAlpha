/*
 * ===> Question: 2: Climbing Stairs.
 * 
 * See notes for understanding...!!
 * 
 * Solve using 3 ways:
 * 1) Simple Recursion.
 * 2) Recursion + Memoization.
 * 3) Tabulation - Iteration / Loop.
 * 
 * ____________________________________________________
 *              -:Time Complexity:-
 *            Simple Recursion: O(2^n)
 *         Recursion + Memoization: O(n)
 *                Tabulation: O(n)
 */

import java.util.Arrays;

public class B_ClimbingStairs {
    // ---> Count Ways - Simple Recursion.
    public static int countWaysRecursion(int n) { // O(2^n)
        if(n == 0) { // 0 to 0 is 1 way.
            return 1;
        }
        if(n < 0) {
            return 0;
        }

        return countWaysRecursion(n - 1) + countWaysRecursion(n - 2);
    }

    // ---> Count Ways - Memoization Recursion. (Top Down)
    public static int countWaysMemoization(int n, int dp[]) { // O(n)
        if(n == 0) { // 0 to 0 is 1 way.
            return 1;
        }
        if(n < 0) {
            return 0;
        }

        if(dp[n] != -1) { // already calculated.
            return dp[n];
        }

        dp[n] = countWaysMemoization(n - 1, dp) + countWaysMemoization(n - 2, dp);
        
        return dp[n];
    }

    // ---> Count Ways - Tabulation. (Bottom Up)
    public static int countWaysTabulation(int n) { // O(n)
        int dp[] = new int[n + 1]; // we find out solution of dp[n] ---> so size of array = n + 1.
        dp[0] = 1; // Assign base case value.

        for (int i = 1; i <= n; i++) {
            if(i == 1) { // if i-2 (1-2 = -1) is negative then take 0.
                dp[i] = dp[i-1] + 0; // 0 ---> dp[i-2] but i-2 = -ve (negative.)
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println("Using Simple Recursion\nWays: "+countWaysRecursion(n));

        int ways[] = new int[n + 1];
        Arrays.fill(ways, -1); // Intially fill Arrasy with -1.

        System.out.println("Using Memoization\nWays: "+countWaysMemoization(n, ways));

        System.out.println("Using Tabulation\nWays: "+countWaysTabulation(n));
    }
}
