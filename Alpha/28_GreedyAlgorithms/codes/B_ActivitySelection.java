/*
 * Company: Facebook, Flipkart, Morgon Stainly
 * ===> Activity Selection <---MIMP---MIMP---MIMP-->
 * ---> Part B: Activities are not sorted according to end time.
 * ---> Simillar topics: [Disjoint set, Max meeting in a room] (Same concept)
 *
 * Problem:
 * You are given n activities with their start and end times. Select the maximum number of activites that can be
 * performed by a Single person, assuming that a person can only work on a Single activity at a time.
 *
 * Time Complexity: O(n logn + n) = O(n logn)
 *
 */

import java.util.*;

public class B_ActivitySelection {

    public static void main(String[] args) {
        int start[] = {5, 8, 5, 0, 3, 1};
        int end[] = {9, 9, 7, 6, 4, 2};

        // Create 2-D Array. Row = start.length & Column = 3 (index column, start column, end column.)
        int activites[][] = new int[start.length][3]; // n-Row * 3 Column. [index column, start column, end column.]
        for (int i = 0; i < start.length; i++) {
            activites[i][0] = i; // storing index of Activity.
            activites[i][1] = start[i]; // storing start of Activity.
            activites[i][2] = end[i]; // storing end of Activity.
        }

        // sorting according to end time. (column index number of end: 2)
        // lambda interface is use. ---> write function in short format.
        Arrays.sort(activites, Comparator.comparingDouble(o -> o[2])); // ----> Time Complexity: O(n logn)

        // end time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>(); // Storing the index of Activity.

        // 1st Activity
        maxAct = 1;
        ans.add(activites[0][0]);
        int lastEnd = activites[0][2];

        for (int i = 1; i < end.length; i++) {
            if (activites[i][1] >= lastEnd) {
                // Activity select
                maxAct++;
                ans.add(activites[i][0]); // add index of activity in ans ArrayList.
                lastEnd = activites[i][2]; // store ending time of current activity.
            }
        }

        System.out.println("Max Activites = " + maxAct);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }
}
