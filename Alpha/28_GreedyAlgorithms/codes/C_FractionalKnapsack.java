/*
 * ===> Fractional knapsack. (IMP, CLASSICAL)
 */

import java.util.*;

public class C_FractionalKnapsack {
    public static void main(String[] args) {
        int val[] = {60,100,120};
        int weight[] = {10,20,30};
        int W = 50;

        double ratio[][] = new double[val.length][2];
        // 0th col ==> idx; 1st col ==> Ratio

        for(int i=0; i<val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        }

        // Sort - On basis of 1st coloum (Ratio coloumn).
        // Ascending order.
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int finalValue = 0;
        
        // we need in descending order.
        for(int i=ratio.length-1; i>=0; i--) {
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]) { // include full item.
                finalValue += val[idx];
                capacity -= weight[idx];
            } else {
                // include fractional item
                finalValue += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        // Printing Answer. (Final value)
        System.out.println("Final value = "+finalValue);
    }
}
