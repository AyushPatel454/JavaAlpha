/*
 * ===> Question: 2: Target Sum Subset. (Variation of 0-1 Knapsack.)
 * 
 * Example:
 * val[] = {4, 2, 7, 1, 3}
 * Target Sum = 10
 * Answer = True. 
 * 
 * Explanation:
 * set1: {7, 3}         sum = 10
 * set2: {7, 2, 1}      sum = 10    
 * set3: {4, 2, 3, 1}   sum = 10
 * 
 * ____________________________________________________________________________________________
 * 
 * Simillar is 0-1 knapsack problem. (Approach is same to same as 0-1 knapsack.)
 * Solve using Tabulation method.
 * 
 * 2 variables which are changes again and again. 
 * 1) n (item number -> i)
 * 2) sum (targest sum -> j)
 * 
 * Simillaritys:
 * - Choice of element (inculde or not.)
 * - Limit on max allowed capacity.
 * - Value = weight.
 * ____________________________________________________________________________________________
 * 
 * Step 1): Table Create. ---> 2D Array: dp[Items + 1][sum + 1]
 * Step 2): Assign Meaning. + Initialize with Base Case.
 *          Meaning:
 *                  ans ---> n items ===> Subset sum = Target ? True/False
 *                  dp(i, j) ---> i items ===> Subset sum = j ? True/False
 *                  i = 3, j = 5 ---> 3 items ===> Subset sum = 5 ? True/False ----> False.
 *                          first 3 items are: {4, 2, 7} & Target sum is 5. ---> Not possible
 *          Base Case:
 *                  1) Sum = 0 ------------> True (dp[i][0] = True.)
 *                          game tetli items hoy & Target sum = 0 hoy to answer true ave.
 *                          Because: Empty Set { } = 0
 *                  2) Items = 0 & Targest Sum > 0 -----> False (dp[0][i] = false)
 * ____________________________________________________________________________________________
 * 
 * Using Tabulation method.
 * Time Complexity: O(n * sum)
 */

public class B_TargetSum_Subset {
    // Target Sum Subset ---using---> Tabulation.
    public static boolean targetSumSubset_Tabulation(int val[], int sum) { // O(n * W)
        int n = val.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        // assign value with base case.
        // Target Sum = 0 ---> Then return True. (0th coloumn) // ---> Because no matter how many items given. We take empty set only. { }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        
        // i = items
        // j = target sum
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                int v = val[i-1]; // value of ith item.

                // inculde
                if(v <= j && dp[i-1][j-v] == true) {
                    dp[i][j] = true;
                }
                // exculde
                else if(dp[i-1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }

        print(dp);

        System.out.print("Answer = ");
        return dp[n][sum];
    }
    
    // print dp table.
    public static void print(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int value[] = {4, 2, 7, 1, 3};
        int targetSum = 10;
        
        // print table
        System.out.println(targetSumSubset_Tabulation(value, targetSum));
    }
}
