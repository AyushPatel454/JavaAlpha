/*
 * ===> Question: 1: Longest Common Substring.
 * _____________________________________________________________________________________
 * (Variation of Longest Commong Subsequence.)
 * _____________________________________________________________________________________
 * A Substring is a contiguous sequence of charchters within a string.
 * _____________________________________________________________________________________
 * String:- "abcde"
 * Substrings: abc , cd, de, abcde, 
 * ac ---> Not substring.
 * _____________________________________________________________________________________
 * Example 1:
 * S1 = "ABCDE"
 * S2 = "ABGCE"
 * Longest Common Substring = "AB" 
 * Ans = 2
 * 
 * Example 2:
 * S1 = "ABCDGH"
 * S2 = "ACDGHR"
 * Longest Common Substring = "CDGH" 
 * Ans = 4
 * _____________________________________________________________________________________
 * Method used: Tabulation.
 * _____________________________________________________________________________________
 * Time Compelexity = O(n * m)
 * _____________________________________________________________________________________
 * See notes for better understanding...!!
 */

public class A_LongestCommonSubstring {
    // ---> Longest Common Subsequence ---using---> Tabulation Method.
    public static int longestCommonSubstring(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];
        int ans = 0; // store final ans.

        // initlization with base case.
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < m+1; j++) {
            dp[0][j] = 0;
        }

        // bootom up
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) { // same charachter.
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                } else { // Different charachter.
                    dp[i][j] = 0; // Reset counter.
                }
            }
        }

        print(dp,str1, str2);

        return ans;
    }

    // print dp[][]
    public static void print(int dp[][], String str1, String str2) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "ABGCE"; // Ans: 2 "AB"

        System.out.println("Longest Common Substring length = "+longestCommonSubstring(str1, str2));
    }
}
