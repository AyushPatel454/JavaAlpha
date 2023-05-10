/*
 * ===> Question 2: Max Length Chain Of Pairs. (Same question of Activity selection.)
 * 
 * You are given N pairs of numbers. In every pair, the first number is always smaller than the
 * second number. A pair(c,d) can come after pair (a, b) if b<c.
 * Find the longest chain which can be formed from a given set of pairs.
 * 
 * Pairs = (5,24) (39, 60) (5, 28) (27, 40) (50, 90)
 * Ans = 3
 * 
 * Time complexity: O(n log(n)) [Because of sorting. Sorting time complexity is = O(n log(n))]
 */

import java.util.*;

public class E_MaxLengthChaiOfPairs {
    public static void main(String[] args) {
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        // Sorting pairs. - based on 2nd Number.
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1])); // Time complexity: O(n log(n))

        int chainLen = 1; // select 1st chainLen (pair)
        int chainEnd = pairs[0][1]; // Last selected pair end //chain end

        for(int i=1; i<pairs.length; i++) {
            if(pairs[i][0] > chainEnd) {
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }

        // Print answer.
        System.out.println("Max length of chain = "+chainLen);
    }
}
