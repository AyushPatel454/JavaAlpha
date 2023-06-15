/*      (Concept)
 * ===> Catalan's Number. (Concept/Qs)
 * _____________________________________________________________________________________
 * Catalan's is sequence of number like fibonacci.
 * _____________________________________________________________________________________
 * Fibnoacci: f0 = 0; f1 = 1; f2 = 1; f3 = 2; f4 = 3; f5 = 5
 * Catqalan's numebr: C0 = 1; C1 = 1; C2 = 2; C3 = 5; C4 = 14; C5 = 42
 * _____________________________________________________________________________________
 * Fixed:-
 * C0 = 1
 * C1 = 1
 * _____________________________________________________________________________________
 * Formula:-
 * Cn = C(0)*C(n-1) + C1 * C(n-2) + C2 * C(n-3) + ... + C(n-3) C2 + C(n-2) C1 + C(n-1) C0
 * _____________________________________________________________________________________
 * C4 = (C0 * C3) + (C1 * C2) + (C2 * C1) + (C3 * C0)
 *    = (1 * 5) + (1 * 2) + (2 * 1) + (5 * 1)
 *    = 5 + 2 + 2 + 5
 * C4 = 14
 * _____________________________________________________________________________________
 *                                     -:Methods:-
 *                                    1) Recursion
 *                                    2) Memoization
 *                                    3) Tabulation
 * _____________________________________________________________________________________
 * -:Time Complexity:-
 * 1) Recursion = Very High
 * 2) Memoization = O(n^2)
 * 3) Tabulation = O(n^2)
 */

import java.util.Arrays;

public class B_CatalanNumber {
    // ---> Catalan Numebr ---using---> Recursion
    public static int catalanRecursion(int n) { // Time Complexity = Very high.
        // base case. // C0 = 1 , C1 = 1
        if(n == 0 || n == 1) {
            return 1;
        }

        int ans = 0; // Cn ---> Catalan of n.

        for (int i = 0; i <= n-1; i++) {
            ans += catalanRecursion(i) * catalanRecursion(n-1-i);
        }

        return ans;
    }

    // ---> Catalan Numebr ---using---> Memoization
    public static int catalanMemoization(int n, int[] dp) { // nearest Time complexity = O(n^2)
        // base case. // C0 = 1 , C1 = 1
        if(n == 0 || n == 1) {
            return 1;
        }

        if(dp[n] != -1) { // If Cn (Catalan of n)already calaculated ---then---> Return.
            return dp[n];
        }

        int ans = 0; // Cn ---> Catalan of n.

        for (int i = 0; i <= n-1; i++) {
            ans += catalanRecursion(i) * catalanRecursion(n-1-i);
        }
        dp[n] = ans; // Store Cn in dp[n].
        return dp[n];
    }

    // ---> Catalan Number ---using---> Tabulation
    public static int catalanTabulation(int n) { // O(n^2)
        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) { // Ci ---> Find C2, C3, C4 , .... , Cn
            for (int j = 0; j < i; j++) { // Ci += Cj * Ci-j-1
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4; // 14
        // int n = 5; // 42
        // int n = 30; // answer not printing because my stack is full in Recursion method.
        System.out.println("Using Recursion: "+catalanRecursion(n));

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println("Using Memoization: "+catalanMemoization(n, dp));


        System.out.println("Using Tabulation: "+catalanTabulation(n));
    }
}
