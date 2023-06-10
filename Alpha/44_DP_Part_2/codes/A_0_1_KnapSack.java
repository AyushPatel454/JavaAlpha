/*
 * ===> Question: 1: 0-1 KnapSack.
 * 1 ---> Inculde Item.
 * 0 ---> Exculde Item.
 * 
 * knapsack = bag.
 * 
 * you given a array of Value[] & it's weight[] & also given a size of knapsack(bag) W.
 * you need to find out maximum profit.
 * 
 * 3 ways:
 *      1) Simple Recursion.
 *      2) Memoization.
 *      3) Tabulation.
 * 
 * ________________________________________________________________________________________
 *              -:Time Complexity:-
 *            Simple Recursion: O(2^n)
 *               Memoization: O(n*W)    (totalItem * MaxWeigh W)
 *               Tabulation: O(n*W) (totalItem * MaxWeigh W)
 */

public class A_0_1_KnapSack {
    // ---> 0-1 KnapSack ---using---> Simple Recursion.
    public static int knapSakRecursion(int val[], int wt[], int W, int n) { // O(2^n)
        if(W == 0 || n == 0) {
            return 0;
        }

        if(wt[n-1] <= W) { // valid ---> Inculde & Exculde
            // inculde
            int ans1 = val[n-1] + knapSakRecursion(val, wt, W-wt[n-1], n-1);
            // exculde
            int ans2 = knapSakRecursion(val, wt, W, n-1);

            return Math.max(ans1, ans2);
        } else { // Not valid. ---> Exculde only.
            // exculde
            int ans = knapSakRecursion(val, wt, W, n-1);
            
            return ans;
        }
    }

    // ---> 0-1 KnapSack ---using---> Advance Recursion -------> Memoization.
    public static int knapSakMemoization(int val[], int wt[], int W, int n, int dp[][]) { // O(n * W)
        if(W == 0 || n == 0) {
            return 0;
        }

        if(dp[n][W] != -1) { // already calculated.
            return dp[n][W];
        }

        if(wt[n-1] <= W) { // valid ---> Inculde & Exculde
            // inculde
            int ans1 = val[n-1] + knapSakMemoization(val, wt, W-wt[n-1], n-1, dp);
            // exculde
            int ans2 = knapSakMemoization(val, wt, W, n-1, dp);

            dp[n][W] = Math.max(ans1, ans2);
            
            return dp[n][W];
        } else { // Not valid. ---> Exculde only.
            // exculde
            dp[n][W] = knapSakMemoization(val, wt, W, n-1, dp);
            
            return dp[n][W];
        }
    }

    // ---> 0-1 KnapSack ---using---> Tabulation.
    // 2 variables change each time in Recursion. (W & n) --so--> Create 2D - Array. dp[n+1][W+1]
    public static int knapTabulation(int val[], int wt[], int W) { // O(n * W)
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        // Initialize with base case.
        for (int i = 0; i < dp.length; i++) { // 0th coloumn.
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
                int value = val[i-1]; // ith item of val.
                int weigh = wt[i-1]; // ith item of wt.

                if(weigh <= j) { // valid. ---> Current item weight is low then J.
                    int inculdeProfit = value + dp[i-1][j-weigh]; // J weight - current weight. = Reamaing weight ---> dp[i-1][j-weight] = maxProfit get for remaing weight.
                    int exculdeProfit = dp[i-1][j];

                    dp[i][j] = Math.max(inculdeProfit, exculdeProfit);
                } else { // invalid. ---> Current item weight is high then J.
                    int exculdeProfit = dp[i-1][j];
                    dp[i][j] = exculdeProfit;
                }
            }
        }

        print(dp);

        return dp[n][W];
    }

    // print dp table.
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
        int W = 7; // Max Weight. Capacity of bag.

        System.out.println("Using Simple Recursion:\nMax Profit: " + knapSakRecursion(val, wt, W, val.length));

        int dp[][] = new int[val.length + 1][W+1];
        // Initalize with value = -1.
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("Using Memoization:\nMax Profit: "+knapSakMemoization(val, wt, W, val.length, dp));

        System.out.println("Using Tabulation:");
        System.out.println("Max Profit: "+knapTabulation(val, wt, W));
    }
}
