/*
 * ===> Question: 1: Coin Change.
 * (Variation of Unbounded Knapsack.)
 * Find number of ways to achieve sum with help of given coins.
 * (We can use same coin multiple time to achieve sum. ---> Unbounded kanpasack.)
 * 
 * Example:
 * val[] = {2, 5, 3, 6};
 * sum = 10
 * Total number of Ways = 5
 *      {2, 2, 2, 2, 2}
 *      {2, 2, 3, 3}
 *      {2, 2, 6}
 *      {2, 3, 5}
 *      {5, 5}
 * __________________________________________________________
 * Method use: Tabulation Method.
 * __________________________________________________________
 * See notes...!!
 * __________________________________________________________
 * Time Complexity = O(n * sum)
 */

public class A_CoinChange {
    public static int coinChange(int coins[], int sum) {
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];

        // Initialize.
        // With base case.
        //  i ---> Coins; j ---> sum/change.
        for (int i = 0; i < n+1; i++) { // if sum = 0 given so there is always 1 way. (It's also consider as a way.)
            dp[i][0] = 1;
        }
        for (int j = 1; j < sum+1; j++) { // if 0 items given & sum > 0 then total ways = 0.
            dp[0][j] = 0;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if(coins[i-1] <= j) {
                    int inculdeWays = dp[i][j - coins[i-1]]; // item inculde.
                    int exculdeWays = dp[i-1][j]; // exculde
                    dp[i][j] = inculdeWays + exculdeWays; // total ways.
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        print(dp);

        System.out.print("Answer = ");
        return dp[n][sum];
    }
    
    // print - dp[][]
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
        int coins[] = {2, 5, 3, 6};
        int sum = 10; // ans = 5

        System.out.println(coinChange(coins, sum));
    }
}
