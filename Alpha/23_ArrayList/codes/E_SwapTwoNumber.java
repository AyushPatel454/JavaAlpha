/*
 * Question: 4: Swap 2 Numbers.
 * list = 2,5,9,3,6       index: idx1 = 1 , idx2 = 3
 * 
 * Time Complexity: O(1)
 */

import java.util.*;
public class E_SwapTwoNumber {
    // Swapping function
    public static void swap(ArrayList<Integer> list, int idx1 , int idx2) {
        // Swapping
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        System.out.println("Before Swapping:" + list);
        
        swap(list, 1, 3); // function calling
        
        System.out.println("After Swapping:" + list);
    }
}
