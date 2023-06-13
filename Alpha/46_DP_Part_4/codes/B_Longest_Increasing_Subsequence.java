/*
 * ===> Question: 2: Longest Increasing Subsequence. (LIS)
 * _____________________________________________________________________________________
 *      (Variation of LCS (Longest common Subsequence.))
 * _____________________________________________________________________________________
 * Given you an array[] with some elements. Find Longest Increasing Subsequence.
 * ( Subsequnce in Ascending order. 
 *  + Maintain order in given array
 *  + Unique element )
 * _____________________________________________________________________________________
 * Example:
 * {5, 1, 6} ---------------------> Answer = 2
 * -:Increasing Subsequnce:-
 *      {5}
 *      {1}
 *      {6}
 *      {5, 6} ---> Longest Increasing Subsequence. Length = 2
 * _____________________________________________________________________________________
 * Example:
 * arr[] = {50, 3, 10, 7, 40, 80}
 * Answer = 4
 * Explanation:-
 * -:Increasing Subsequnce:-
 *      { 50 }
 *      { 3 }
 *      { 10 }
 *      { 3, 10 }
 *      { 7 }
 *      { 40 }
 *      { 3, 7 }
 *      { 3, 7, 10 }
 *      { 3, 7, 40 }
 *      { 3, 40 }
 *      { 7, 40 }
 *      { 80 }
 *      { 3, 80 }
 *      { 50, 80 }
 *      { 10, 80 }
 *      { 3, 10 , 80 }
 *      { 7, 80 }
 *      { 40, 80 }
 *      { 3, 7, 80 }
 *      { 3, 7, 10, 80 }   -----> Longest Increasing Subsequnce. Length = 4
 *      { 3, 7, 40, 80 }   -----> Longest Increasing Subsequnce. Length = 4
 *      { 3, 40, 80 }
 *      { 7, 40, 80 }
 * _____________________________________________________________________________________
 * Time Complexity = O(n * m)
 * _____________________________________________________________________________________
 * See notes for better understandng...!!
 */

import java.util.*;

public class B_Longest_Increasing_Subsequence {
    // ---> Longest Increasing Subsequence. (LIS)
    public static int lis(int arr1[]) {
        HashSet<Integer> set = new HashSet<>(); // for store unique elements.
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        int arr2[] = new int[set.size()]; // for store unique sorted element.
        int i = 0;
        // copy unique elements from set to arr2.
        for(int num : set) { 
            arr2[i] = num;
            i++;
        }

        // sort elements.
        Arrays.sort(arr2);

        return lcs(arr1, arr2); // Find longest common subsequence.
    }

    // ---> Longest common subsequence.
    public static int lcs(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];

        // inilization with base case.
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < m+1; j++) {
            dp[0][j] = 0;
        }

        // bottom up
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(arr1[i-1] == arr2[j-1]) { // same element.
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else { // different element.
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1,ans2);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        int arr[] = {50, 3, 10, 7, 40, 80}; // 4 {3, 10, 40, 80} -:or:- {3, 7, 40, 80}
        System.out.println("Longest Increasing Subsequence = "+lis(arr));
    }
}
