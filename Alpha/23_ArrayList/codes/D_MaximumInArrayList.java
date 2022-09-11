/*
 * Question: 3: Find Maximum in an ArrayList
 * 
 * Time Complexity: O(n)
 */

import java.util.*;
public class D_MaximumInArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        Integer max = Integer.MIN_VALUE; // both are valid
        // int max = Integer.MIN_VALUE;  // both are valid

        for (int i = 0; i < list.size(); i++) {
            // if(list.get(i) > max) {
            //     max = list.get(i);
            // }
            max = Math.max(max, list.get(i));
        }

        System.out.println("Maximum of List: "+max);
    }
}
