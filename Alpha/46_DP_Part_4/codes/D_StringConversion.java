/*
 * ===> Question: 4: String Converstion.
 * _____________________________________________________________________________________
 * (Variation of Edit distance.)
 * _____________________________________________________________________________________
 * convert word1 to in word2. Find minimum operation you perform.
 * You perform 2 operations:-
 *      1) Add operation.
 *      2) Delete Operation.
 * _____________________________________________________________________________________
 * Solve using another method with help of LCS (Longest Common Subsequence).
 * 
 * Find LCS of str1 & str2.
 * Str1 = "abcdef"
 * Str2 = "acg"
 * LCS = 2
 * 
 * Delete operation from str1 = Str1.length() - LCS = 6 - 2 = 4
 * Add operation. 
 *          Add operationos = Remaing charachter of Str2 = Str2.length() - LCS = 3 - 2 = 1
 * 
 * ----------------> Answer = Total operation = add + delete = 1 + 4 = 5
 * _____________________________________________________________________________________
 * Time Complexity = O(n * m)
 */

public class D_StringConversion {
    public static int stringConversion(String str1, String str2) {

        int lcsCommon = lcs(str1, str2);
        System.out.println(lcsCommon);

        int deleteOperations = str1.length() - lcsCommon;
        System.out.println(deleteOperations);

        int addOperations = str2.length() - lcsCommon;
        System.out.println(addOperations);

        return deleteOperations + addOperations;
    }

    // lcs
    public static int lcs(String str1, String str2) {
    // public static int lcs(String str1, String str2, int n, int m) {
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

        return dp[n][m];
    }
    public static void main(String[] args) {
        String word1 = "abcdef"; 
        String word2 = "acg"; // 5
        // String word1 = "a";
        // String word2 = "aceg"; // 3

        System.out.println(stringConversion(word1, word2));
    }
}
