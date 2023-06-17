/*      (Concept)
 * ===> Matrix Chain Multiplication. (MCM) ----> (Concept/Qs)
 * ________________________________________________________________________________
 * You given an Array whose size is n.
 * It store the information of n-1 valid matrix whose multiplication is possible.
 * 
 * You need to find in which order you multiply these matrices so, you give minimum cost give.
 * 
 * Find Min cost.
 * ________________________________________________________________________________
 * Example:-
 * arr[] = {1, 2, 3, 4, 3}
 * Answer = minimum cost (opertion perfom) = 30
 * 
 * Explanation:-
 * n = 5 (Length of Array.)
 * Means total numebr of matrix present in Array = n - 1 = 4
 * 
 *            Matrix (size)
 *              A1 = 1 x 2
 *              A2 = 2 x 3
 *              A3 = 3 x 4
 *              A4 = 4 x 3
 * 
 * ---> Optimal Order of multiplication: ( ( (A1 x A2) x A3 ) x A4 )        NOTE: There is multiple orders of this 4 matrix. Ex: ( (A1 x A2) x (A3 x A4) ) , etc...
 * 
 * ( ( (A1 x A2) x A3 ) x A4 )
 * B = A1 x A2                     B (size) = 1 x 3             cost1 = 1 * 2 * 3 = 6
 * 
 * ( ( B x A3 ) x A4 )
 * C = B x A3                      C (size) = 1 x 4             cost2 = 1 * 3 * 4 = 12
 * 
 * ( C x A4 )
 * D = C x A4                      D (size) = 1 x 3             cost3 = 1 * 4 * 3 = 12
 * 
 * ( D )
 * 
 * Total Cost = cost1 + cost2 + cost3 = 6 + 12 + 12 = 30 ----------> Answer.
 * ________________________________________________________________________________
 * Solve this Question using 3 Variables.
 * i ---> Starting point.
 * j ---> Ending pint.
 * l ---> Start ==> End (Traverse from Strating to Ending point.)
 * ________________________________________________________________________________
 *                          -:Methods used:-
 * 1) Recursion.
 * 2) Memoization.
 * 3) Tabulation.
 * ________________________________________________________________________________
 *                          -:Time Complexity:-
 * 1) Recursion = Very High.
 * 2) Memoization = O(n^2)
 * 3) Tabulation = O(n^2)
 * ________________________________________________________________________________
 * See notes for better understanding...!!
 */

import java.util.Arrays;

public class A_MatrixChainMultiplication_MCM {
    // ---> Matrix Chain Maltiplication (MCM) --using--> Recursion.
    public static int mcmRecursion(int[] arr, int i, int j) {
        // i ---> Starting point.
        // j ---> Ending pint.
        // l ---> Start ==> End (Traverse from Strating to Ending point.)

        // start = end.
        if(i == j) { // single matrix. Cost = 0
            return 0;
        }

        int ans = Integer.MAX_VALUE; // +ve Infinity

        for (int k = i; k < j; k++) {
            int cost1 = mcmRecursion(arr, i, k); // set1 cost.
            // Ai = a x b = arr[i-1] x arr[i]
            // Ak = c x d = arr[k-1] x arr[k]

            // Resultant matrix of (Ai x Ak) ---> size of A[] = arr[i-1] x arr[k] (size)
            // cost 1 = a * b * d = arr[i-1] * arr[i] * arr[k]
            
            int cost2 = mcmRecursion(arr, k+1, j); // set2 cost.
            // Ak+1 = a x b = arr[k] x arr[k+1]
            // Aj = c x d = arr[j-1] x arr[j]

            // Resultant matrix of (Ak+1 x Aj) ---> size of B[] = arr[k] x arr[j] (size)
            // cost 2 = a * b * d = arr[k] * arr[k+1] * arr[j]

            int cost3 = arr[i-1] * arr[k] * arr[j]; // set1 * set2 cost.
            // A[] = a x b = arr[i-1] x arr[k] (size)
            // B[] = c x d = arr[k] x arr[j] (size)

            // Resultant matrix of (A[] x B[]) ---> size of C[] = arr[i-1] x arr[j] (size)
            // cost 3 = a * b * d = arr[i-1] * arr[k] * arr[j]

            int finalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans, finalCost); // store minimum cost.
        }

        return ans;
    }

    // ---> Matrix Chain Maltiplication (MCM) --using--> Memoization.
    public static int mcmMemoization(int arr[], int i, int j, int dp[][]) {
        if(i == j) {
            return 0;
        }

        // already calculated.
        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j-1; k++) {
            int cost1 = mcmMemoization(arr, i, k, dp); // set1
            int cost2 = mcmMemoization(arr, k+1, j, dp); // set2
            int cost3 = arr[i-1] * arr[k] * arr[j]; // set1 * set2

            ans = Math.min(ans, cost1+cost2+cost3);
        }

        dp[i][j] = ans;

        return dp[i][j];
    }

    // ---> Matrix Chain Maltiplication (MCM) --using--> Tabulation.
    public static int mcmTabulation(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        // inlizatation with base case.
        // i == j ---> 0 // single matrix
        for (int i = 0; i < n; i++) {
            int j = i;
            dp[i][j] = 0;
        }

        // bottom up
        for (int len = 2; len <= n-1; len++) { // len ---> total metrix group (len = 2 for A*B , len = 3 for A*B*C)
            for (int i = 1; i <= n-len; i++) {
                int j = i + len - 1; // coloumn.

                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j-1; k++) { // same logic as Memoization.
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1] * arr[k] * arr[j];

                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
                }
            }
        }
        
        System.out.println("\n\nUsing Tabulation...");
        print(dp);

        return dp[1][n-1]; // Final Answer
    }

    // print dp[][]
    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3};
        int n = arr.length;
        /*
         * n = 5
         * Means total numebr of matrix present in Array = n - 1 = 4
         * 
         * Matrix (size)
         * A1 = 1 x 2
         * A2 = 2 x 3
         * A3 = 3 x 4
         * A4 = 4 x 3
         */
        System.out.println("Using Recursion = "+mcmRecursion(arr, 1, n-1));
        
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Using Memoization = "+mcmMemoization(arr, 1, n-1, dp));
        
        System.out.println("Using Tabulation = "+mcmTabulation(arr));
    }
}
