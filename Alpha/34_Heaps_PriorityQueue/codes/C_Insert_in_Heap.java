/*
 * ===> Insert in Heap.
 * 
 * Time complexity = O(log n)
 * 
 * ---> To see complete all function refeter E_Delete_in_Heap.java
 */

import java.util.*;

public class C_Insert_in_Heap {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>(); // Heap implement as ArrayList.

        public void add(int data) { // Time complexity = O(log n)
            // add at last idx
            arr.add(data);

            int x = arr.size() - 1;     // x is child index.
            int parentIdx = (x - 1)/2;  // parent index.

            // child < parent
            while(arr.get(x) < arr.get(parentIdx)) { // Time complexity = O(log n)
                // Swap
                int temp = arr.get(x);
                arr.set(x, arr.get(parentIdx)); // childValue = parentValue.
                arr.set(parentIdx, temp); // parentValue = childValue.

                // update child index & parent index.
                x = parentIdx;
                parentIdx = (x - 1)/2;
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
