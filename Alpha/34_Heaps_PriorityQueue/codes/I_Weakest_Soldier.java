/*
 * ===> Question: 3: Weakest Soldier.
 * We are given an m*n (m x n) binary matrix of 1's (Soldiers) and 0's (Civilians).
 * The soldiers are positioned in front of the civilians. That is, all the 1's will
 * appear to the left of all the 0's in each row.
 * 
 * A row I is weaker than a row J if one of the following is true:
 *      -> The number of soldiers in row I is less than the number of soldiers in row J.
 *      -> Both rows have the same number of soldiers and I < J.
 * 
 * Find the K weakest rows.
 * 
 * ---> Example:
 * m = 4, n = 4, k = 2
 *  1 0 0 0             Ans = row0 & row2
 *  1 1 1 1
 *  1 0 0 0
 *  1 0 0 0
 */

import java.util.*;

public class I_Weakest_Soldier {
    static class Row implements Comparable<Row> {
        int soldiers; // Count of soldiers.
        int idx; // Row index.

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            
            if(this.soldiers == r2.soldiers) { // If soldiers count same ---> sort on basis of inedx.
                return this.idx - r2.idx;
            } else { // Sort on basis of soldiers.
                return this.soldiers - r2.soldiers;
            }
        }
    }

    public static void main(String[] args) {
        int army[][] = {
                        {1, 0, 0, 0},
                        {1, 1, 1, 1},
                        {1, 0, 0, 0},
                        {1, 0, 0, 0}};
        
        int k = 2;

        PriorityQueue<Row> pq = new PriorityQueue<>();

        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army[0].length; j++) { // count total 1 appear in Row.
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("R"+pq.remove().idx);
            // pq.remove();
        }
    }
}
