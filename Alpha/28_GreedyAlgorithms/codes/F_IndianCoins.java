/*
 * ===> Question: 3: Indian Coins.
 * We are given an infinite supply of denomination [1, 2, 5, 10, 20, 50, 100, 500, 2000].
 * Find minimum number of coins/notes to make change for value V.
 * 
 * Example:
 * V = 123 ---> ans = 3 (100+20+1)
 * V = 590 ---> ans = 4 (500+50+20+20)
 */

import java.util.*;

public class F_IndianCoins {
    public static void main(String[] args) {
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        // Sort in descending order.
        // For sort in descending order it's requrie to object type is Integer.
        Arrays.sort(coins, Comparator.reverseOrder());

        int counOfCoins = 0;
        int amount = 590;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            if(coins[i] <= amount) {
                while(coins[i]<=amount) {
                    counOfCoins++; // increase count. By 1
                    ans.add(coins[i]); // add coins in ans list.
                    amount -= coins[i]; // subtract coin from amount.
                }
            }
        }

        // Printing answer.
        System.out.println("Total (min) coins used = "+counOfCoins);
        System.out.println("Currency used: "+ans);
    }
}
