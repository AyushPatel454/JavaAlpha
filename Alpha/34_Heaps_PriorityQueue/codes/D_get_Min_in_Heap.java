/*
 * ===> Get Min in Heap.
 * Get minimum value (highest prority) element from ArrayList.
 *
 * Time complexity = O(1)
 * 
 * ---> To see complete all function refeter E_Delete_in_Heap.java
 */

import java.util.*;

public class D_get_Min_in_Heap {

    static class Heap {

        ArrayList<Integer> arr = new ArrayList<>(); // Heap implement as ArrayList.

        public void add(int data) { // Time complexity = O(log n)
            // add at last idx
            arr.add(data);

            int x = arr.size() - 1; // x is child index.
            int parentIdx = (x - 1) / 2; // parent index.

            // child < parent
            while (arr.get(x) < arr.get(parentIdx)) { // Time complexity = O(log n)
                // Swap
                int temp = arr.get(x);
                arr.set(x, arr.get(parentIdx)); // childValue = parentValue.
                arr.set(parentIdx, temp); // parentValue = childValue.

                // update child index & parent index.
                x = parentIdx;
                parentIdx = (x - 1)/2;
            }
        }

        // ---> Min in Heap.: Peak minimum value (High priority.)
        public int peek() {
            return arr.get(0); // 0th index element is my minimum in my heap.
        }
    }

    public static void main(String[] args) {
    }
}
