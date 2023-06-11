/*
 * ===> Question: 2: Rod cutting.
 * (Varitation of Unbounded knapsack.) (Ditto same code of unbounded knapsack)
 * 
 * Given a rod of n inches & an array of prices that inculdes prices of all pieces of size smaller than n Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * ________________________________________________________________________________________________
 * Gujrati Explenation:
 * Ek pipe che jeni length = n che.
 * Tame ena nana - nana parts karo cho ane market ma vechva jaav cho.
 * To tamare total n inch ni pipe na tukda vechva na che.
 * Tukda ni length pramane bhavv alag-alag che.
 * To tame kaya-kaya pieces (parts) vechso. Total n inch ni pipe mate jethi MAXIUM_PROFIT made.
 * ________________________________________________________________________________________________
 * Example:
 * length = {1, 2, 3, 4, 5, 6, 7, 8}
 * price = {1, 5, 8, 9, 10, 17, 17, 20}
 * Rod Length = 8
 * Answer: Maximum Profit = 22.
 * ________________________________________________________________________________________________
 * NOTE: This question is ditto same as Unbounded knapsack. Code is also same with no changes of Unbounded knapsack.
 *      In iterview this type of question asked instead of Unbound knapsack.
 * 
 * --> only variable name is change.
 * value = price.
 * wt = length.
 * W = Total length of Rod. (Capacity)
 * ________________________________________________________________________________________________
 * Time Complexity = O(n * RodLength)
 */

public class B_RodCutting {
    // ---> RodCutting - Unbounded Knapsack.
    public static int rodCutting(int length[], int price[], int totalRod) { // O(n * RodLength)
        int n = price.length;
        int dp[][] = new int[n+1][totalRod+1];

        // Initilization with base case.
        for (int i = 0; i < n+1; i++) { // length = 0 then maxProfit = 0
            dp[i][0] = 0;
        }
        for (int j = 0; j < totalRod + 1; j++) { // items = 0 then maxProfit = 0
            dp[0][j] = 0;
        }

        // i ---> length.
        // j ---> price.
        // Unbounded Knapsack approach same to same.
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < totalRod+1; j++) {
                if(length[i-1] <= j) { // valid.
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]); // (inculde, exculde)
                } else { // invalid.
                    dp[i][j] = dp[i-1][j]; // (exculde)
                }
            }
        }
        
        print(dp);

        System.out.print("Answer = ");

        return dp[n][totalRod];
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
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = 8;

        System.out.println(rodCutting(length, price, rodLength));
    }
}
