/*
 * ===> Question: 3: Unbounded Knapsack.
 * We can select 1 item multiple time to add in knapsack(bag).
 * 
 * in 0-1 knapsack we select item only 1 time to add in knapsack(bag).
 * ________________________________________________________________________________________________________________________________________________________________________________________________
 * Method use: Tabulation Method.
 * ________________________________________________________________________________________________________________________________________________________________________________________________
 * Unbounded Knapsack solution is 99% same as 0-1 knapsack.
 * 
 * only one small changes in 0-1 knasack to make unbounded knapsack.
 * ________________________________________________________________________________________________________________________________________________________________________________________________
 * ----> Change:
 *          inculde itemp in knapsack. (select ith item againg for remaning weight.) (0 to i items allow.)
 *                  inculdeProfit = value of ith item + dp[i][j-V]      {Where V is current ith item weight.} {Remanign Weight = j - V} {We fill remanig weight form 0 to ith items.}
 *          in 0-1 knapsack. (no selecte ith item again for remaning weight.) (0 to i-1 items allow.)
 *                  inculdeProfit = value of ith item + dp[i-1][j-V]      {Where V is current ith item weight.} {Remanign Weight = j - V} {We fill remanig weight form 0 to (i-1)th items.}
 * 
 * ________________________________________________________________________________________________________________________________________________________________________________________________
 * Time Complexity: O(n * W)
 */

public class C_UnboundedKnapSack {

    // ---> Unbounded Knapsack. ---> Using Tabulation method.
    public static int unboundedKnapsack(int val[], int wt[], int W) { // O(n * W)
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        // inslization with base case.
        // W = 0 ---> dp[i][0] = 0
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 0;
        }
        // Items = 0 ---> dp[0][i] = 0
        for (int i = 0; i < W+1; i++) {
            dp[0][i] = 0;
        }

        // 0-1 knap sack code with small changes in inculde time.
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
                if(wt[i-1] <= j) { // valid.
                    dp[i][j] = Math.max(val[i-1] + dp[i][j - wt[i-1]], dp[i - 1][j]); // inculde , exculde
                } else { // invalid.
                    dp[i][j] = dp[i - 1][j]; // exculde.
                }
            }
        }

        print(dp); // print dp[][]
        
        System.out.print("Answer = ");

        return dp[n][W];
    }

    // print dp
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
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;

        System.out.println(unboundedKnapsack(val, wt, W));
    }
}
