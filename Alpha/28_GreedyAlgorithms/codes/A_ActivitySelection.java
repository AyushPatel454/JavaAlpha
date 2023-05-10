/*
* Company: Facebook, Flipkart, Morgon Stainly
 * ===> Activity Selection <---MIMP---MIMP---MIMP-->
 * ---> Part A: Activities are sorted according to end time (Given.)
 * ---> Simillar topics: [Disjoint set, Max meeting in a room] (Same concept)
 * 
 * Problem:
 * You are given n activities with their start and end times. Select the maximum number of activites that can be
 * performed by a Single person, assuming that a person can only work on a Single activity at a time.
 * Activities are sorted according to end time. (given)
 * 
 * Time Complexity: O(n)
 * 
 */

import java.util.*;

public class A_ActivitySelection {
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        // end time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>(); // Storing the index of Activity.

        // 1st Activity
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];

        for (int i = 1; i < end.length; i++) {
            if(start[i] >= lastEnd) {
                // Activity select
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("Max Activites = "+maxAct);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A"+ans.get(i) + " ");
        }
        System.out.println();
    }
}
