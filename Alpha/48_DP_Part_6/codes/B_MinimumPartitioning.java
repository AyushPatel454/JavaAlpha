/*
 * ===> Question: 1: Minimum Partitioning.
 * ________________________________________________________________________________
 *                  (Variation of 0-1 knap sack)
 * ________________________________________________________________________________
 * You given an array[]. You need to divide on element in 2 sets & find minimum
 * absoulte difference between 2 sets.
 * ________________________________________________________________________________
 * Example:-
 * number[] = {1, 6, 11, 5}
 * Minimum Difference = 1
 * 
 * Explanation:
 * ------------Divide elements in 2 sets.------------
 * 1) set1 = {1, 6}  sum1 = 7         set2 = {11, 5} sum2 = 16   ---> Difference = |sum1 -sum2| = |7 - 16| = 9
 * 2) set1 = {1, 11} sum1 = 12        set2 = {6, 5} sum2 = 11    ---> Difference = |sum1 -sum2| = |12 - 11| = 1  ===>  Answer.
 * 3) set1 = {1, 5}  sum1 = 6         set2 = {6, 11} sum2 = 17   ---> Difference = |sum1 -sum2| = |6 - 17| = 11
 * 
 * Hence, Minimum Difference = 1
 * ________________________________________________________________________________
 * Time Complexity = O(n * W)
 * ________________________________________________________________________________
 * See notes for better understanding...!!
 */

public class B_MinimumPartitioning {
    public static int minimumPartitioning(int[] arr) {
        int n = arr.length;
        // sum of all number.
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int W = sum/2; // Knap Sack Max Size.

        int dp[][] = new int[n+1][W+1];

        // Inilize with base case.
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < W+1; j++) {
            dp[0][j] = 0;
        }

        // bottom up fill.
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
                if(arr[i-1] <= j) { // valid

                    int inculde = arr[i-1] + dp[i-1][j-arr[i-1]]; // inculde
                    int exculde = dp[i-1][j]; // exculde

                    dp[i][j] = Math.max(inculde, exculde);

                } else { // invalid
                    dp[i][j] = dp[i-1][j]; // exculde.
                }
            }
        }

        int sum1 = dp[n][W];
        int sum2 = sum - sum1;

        int minDiff = Math.abs(sum1 - sum2);

        return minDiff;
    }
    public static void main(String[] args) {
        // int number[] = {1, 6, 11, 5}; // minimum difference = 1
        int number[] = {1, 2, 3}; // minimum difference = 0

        System.out.println("Minimum Difference between 2 sets = " + minimumPartitioning(number));
    }
}
