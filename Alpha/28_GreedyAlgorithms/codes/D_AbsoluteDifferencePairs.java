/*
 * ===>Question 1: Min Absolute Difference Pairs.
 * 
 * Given two arrays A and B of equal length N. Pair each element of array
 * A to an element in array B, such that sum S of absolute difference of
 * all the pair is minimu.
 * 
 * Time comoplexity: (n log(n))
 */

import java.util.*;

public class D_AbsoluteDifferencePairs {
    public static void main(String[] args) {
        int A[] = {4, 1, 8, 7};
        int B[] = {2, 3, 6, 5};

        // Sort both array.
        Arrays.sort(A); // Time complexity: O(n log n)
        Arrays.sort(B);

        int minDiff = 0;

        for(int i=0; i<A.length; i++) {
            minDiff += Math.abs(A[i]-B[i]); // Finding Absolute: |a - b|
        }

        // Printing Answer.
        System.out.println("Min Absolute Difference of pairs = "+minDiff);
    }
}
