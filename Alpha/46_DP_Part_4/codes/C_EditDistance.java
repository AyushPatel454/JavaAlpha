/*
 * ==> Question: 3: Edit Distance.
 * _____________________________________________________________________________________
 * Given 2 strings word1 & word2, return the minimum number of operations required to
 * convert word1 to word2.
 * You have the following 3 Operations permitted on a word:-
 *      1) Insert a charchter. (add)
 *      2) Delete a character. (delete)
 *      3) Replace a charachter. (Replace)
 * _____________________________________________________________________________________
 * Example:
 * word1 = "intension"
 * word2 = "execution"
 * Answer = Minimum Operations = 5
 * -:Explanation:-
 *          intension ---> inention (Remove 't')
 *          inention ---> enention (Replace 'i' with 'e')
 *          enention ---> exention (Replace 'n' with 'x')
 *          exention ---> exection (Replace 'n' with 'c')
 *          exection ---> execution (Insert 'u')
 * _____________________________________________________________________________________
 * Time Complexity = O(n * m)
 * _____________________________________________________________________________________
 * See notes for better understanind...!!
 */

public class C_EditDistance {
    public static int editDistance(String str1, String str2) { // O(n * m)
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];

        // Inilizate with base case.
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                // str1 = " " (Empty) --then--> total operation = str2.length
                // Add operation.
                if(i == 0) {
                    dp[i][j] = j; // 1st row.
                }
                // str2 = " " (Empty) --then--> total operation = str1.length
                // Delete operation.
                if(j == 0) {
                    dp[i][j] = i; // 1st coloumn.
                }
            }
        }

        // bottom up.
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) { // same charachter.
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int addOperation = dp[i][j-1] + 1;
                    int deleteOperation = dp[i-1][j] + 1;
                    int replaceOperation = dp[i-1][j-1]+1;

                    dp[i][j] = Math.min(Math.min(addOperation, deleteOperation), replaceOperation);
                }
            }
        }

        print(dp);
        System.out.print("Minimum number of operation = ");

        return dp[n][m];
    }

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
        String word1 = "intention";
        String word2 = "execution"; // 5

        System.out.println(editDistance(word1, word2));
    }
}
