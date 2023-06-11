/*
 * ===> Concepte/Question: 1: Longest Common Subsequence.
 * A subsequence of a string is a new string generated from the orignal string with same characters (can be none) deleted without changing the relative order of the remaning charachters.
 * Find Longest Common subsequence.
 * ___________________________________________________________________________________________________________________
 * Example 1:-
 * Str1 = "abcdefg"
 * 
 * Str2 = "adg" ------> Is sub sequence. (relative order mathc with Str1.) ---> {a comes 1st in Str1 then d comes in Str1 then g comes in Str1}
 * Str2 = "abdg" ------> Is sub sequence.(relative order mathc with Str1.) ---> {a comes 1st in Str1 then b comes in Str1 then d comes in Str1 then g comes in Str1}
 * Str2 = "ba" ------> Is NOT sub sequence.(relative order not mathc with Str1.) ---> {b comes in Str1 after a.}
 * ___________________________________________________________________________________________________________________
 * Example:
 * Str1 = "abcde"
 * Str2 = "ace"
 * Longest Common Subsequence = 3 // "ace"
 * 
 * Str1 = "abcdge"
 * Str2 = "abedg"
 * Longest Common Subsequence = 4 // "abdg"
 * ___________________________________________________________________________________________________________________
 *                              -:Methods:-
 * 1) Simple Recursion ------------> Worst Time Complexity.
 * 2) Memoization
 * 3) Tabulation
 * ___________________________________________________________________________________________________________________
 *                              -:Time Complexity:-
 * 1) Simple Recursion = O(2^(n*m))
 * 2) Memoization = O(n * m)
 * 3) Tabulation = O(n * m)
 * ___________________________________________________________________________________________________________________
 * See notes for better understanding...!!
 * ___________________________________________________________________________________________________________________
 */

public class C_LongestCommonSubsequence {
    // Method - 1.
    // Longest Common Subsequence ---> Using Simple Recursion.
    // Time Complexity = O(2^(n*m))
    public static int lcsRecursion(String str1, String str2, int n, int m) { // n = Length of Str1, m = Length of Str2
        // Base Case:
        // length of Str1 = 0 -:OR:- Length of Str2 = 0 ---then---> Longest Common Subsequnce = 0
        if(n == 0 || m == 0) {
            return 0;
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)) { // same charachter.
            return 1 + lcsRecursion(str1, str2, n-1, m-1);
        } else { // different charachter.
            int ans1 = lcsRecursion(str1, str2, n-1, m);
            int ans2 = lcsRecursion(str1, str2, n, m-1);

            return Math.max(ans1, ans2);
        }
    }

    // Method - 2.
    // Longest Common Subsequence ---> Using Memoization.
    // Time Complexity = O(n * m)
    public static int lcsMemoization(String str1, String str2, int n, int m, int dp[][]) { // n = Length of Str1, m = Length of Str2
        // Base Case:
        // length of Str1 = 0 -:OR:- Length of Str2 = 0 ---then---> Longest Common Subsequnce = 0
        if(n == 0 || m == 0) {
            return 0;
        }

        if(dp[n][m] != -1) { // already calculated lCS.
            return dp[n][m];
        }

        // not calculated then calculate LCS.
        if(str1.charAt(n-1) == str2.charAt(m-1)) { // same charachter.

            dp[n][m] = 1 + lcsRecursion(str1, str2, n-1, m-1);

            return dp[n][m];

        } else { // different charachter.

            int ans1 = lcsRecursion(str1, str2, n-1, m);
            int ans2 = lcsRecursion(str1, str2, n, m-1);

            dp[n][m] = Math.max(ans1, ans2);

            return dp[n][m];
        }
    }

    // Method - 3.
    // Longest Common Subsequence ---> Using Tabulation.
    // Time Complexity = O(n * m)
    public static int lcsTabulation(String str1, String str2) {
        int n = str1.length(); // length of Str1
        int m = str2.length(); // length of Str2

        int dp[][] = new int[n+1][m+1];

        // Initilization - Base case
        // Str1 length = 0 -----------> LCS = 0
        // Str2 length = 0 -----------> LCS = 0
        for (int i = 0; i < n+1; i++) { // i = Str1 length
            for (int j = 0; j < m+1; j++) { // j = Str2 length
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // i ---> Length of Str1
        // j ---> Length of Str2
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) { // Same charachter.
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    int ans1 = dp[i-1][j]; // Up
                    int ans2 = dp[i][j-1]; // Left

                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        System.out.println("\nUsing Tabulation");
        print(dp);
        System.out.print("LCS = ");

        return dp[n][m];
    }

    // print dp[][]
    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg"; // LCS = "abdg"; length = 4
        int n = str1.length();
        int m = str2.length();

        System.out.println("Using Simple Recursion\nLCS = "+lcsRecursion(str1, str2, n, m));

        int dp[][] = new int[n+1][m+1];
        // initially fill dp = -1
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Using Memoization\nLCS = "+lcsMemoization(str1, str2, n, m,dp));

        System.out.println(lcsTabulation(str1, str2));
    }
}
