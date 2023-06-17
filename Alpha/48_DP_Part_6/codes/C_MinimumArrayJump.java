/*
 * ===> Question: 2: Min Array Jumps.
 * ________________________________________________________________________________
 * You given an Array with size n.
 * In which jumps are define you need to reach last element (n-1) from 1st element
 * (0th index). In minimum jumps.
 * 
 * Find minimum jumps requrired to reached 1st element to last element of array.
 * ________________________________________________________________________________
 * Example:-
 * arr[] = {2, 3, 1, 1, 4}
 * Minimum Jumps = 2
 *      2 ---> 3  ---> 4
 * ________________________________________________________________________________
 * See notes for better understanding...!!
 */

import java.util.*;

public class C_MinimumArrayJump {
    public static int minJump(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];

        Arrays.fill(dp, -1); // fill dp[] with value -1

        // Inilize with base case (Small problem).
        dp[n-1] = 0;

        // bottom up.
        // Solve small problem 1st. With help of small problem solve large problem.
        // small problem ---> Large problem // n-2 ---> 0
        for (int i = n-2; i >= 0; i--) {
            int steps = nums[i];
            int ans = Integer.MAX_VALUE;
            for (int j = i+1; j <= i+steps && j < n; j++) {
                if(dp[j] != -1) { // if -1 then it's not valid. // If we take dp[j] = -1 then we can't reached our destination. Because there is no possible jumps preset.
                    ans = Math.min(ans, dp[j]+1);
                }
            }

            if(ans != Integer.MAX_VALUE) {
                dp[i] = ans;
            }
        }

        print(dp);
        
        // final answer = dp[0].
        return dp[0];
    }

    // print dp[]
    public static void print(int dp[]) {
        System.out.print("dp[] = ");
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]+" ");
        }
        System.out.println();
        System.out.println("Answer present on 0th index dp[0] = "+dp[0]);
    }

    public static void main(String[] args) {
        // int arr[] = {2, 3, 1, 1, 4};
        int arr[] = {2, 3, 0, 0, 4};
        System.out.println("Minimum jumps = "+minJump(arr));
    }
}