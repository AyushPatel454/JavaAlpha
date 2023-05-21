/*
 * ===> Delete in Heap.
 * Delete min value (Root node) (Highest prority node/value) in Min Heap.
 * 
 * Time Complexity = O(log n)
 * Heapify Time Complexity = O(log n)
 */

import java.util.*;

public class E_Delete_in_Heap {

    static class Heap {

        ArrayList<Integer> arr = new ArrayList<>(); // Heap implement as ArrayList.

        public void add(int data) { // Time complexity = O(log n)
            // add at last idx
            arr.add(data);

            int x = arr.size() - 1; // x is child index.
            int parentIdx = (x - 1) / 2; // parent index.

            // child < parent
            while (arr.get(x) < arr.get(parentIdx)) { // ---> MIN-HEAP Time complexity = O(log n)
            // while (arr.get(x) > arr.get(parentIdx)) { // ---> MAX-HEAP Time complexity = O(log n)
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

        // ---> Remove in Min Heap. (1st min value)
        public int remove() {
            int data = arr.get(0);
            
            // step1 - swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            // step2 - delete last
            arr.remove(arr.size()-1);

            // step3 - heapify
            heapify(0);

            return data; // remove data return
        }

        // ---> Heapify ---> fix the heap. (Min Heap)
        private void heapify(int i) { // Time complexity = O(log n)
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i; // assume root node is my minimum index.

            // check.
            // left < arr.size() ---> Means my root node is leaf node. & leaf node not contain any left child and right child.
            // root node (whose index = minIdx) value > left child value then ---> minIdx = left idx;
            if(left < arr.size() && arr.get(minIdx) > arr.get(left)) { // ---> MIN-HEAP
            // if(left < arr.size() && arr.get(minIdx) < arr.get(left)) { // ---> MAX-HEAP
                minIdx = left;
            }

            // check.
            // right < arr.size() ---> Means my root node is leaf node. & leaf node not contain any left child and right child.
            // root (whose index = minIdx) value > right child value ---> Then minIdx = right.
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)) { // ---> MIN-HEAP
            // if(right < arr.size() && arr.get(minIdx) < arr.get(right)) { // ---> MAX-HEAP
                minIdx = right;
            }
            
            // If minIdx is change means we fix the heap.
            // Now check after fix it there is any problem or not.
            // To check we again re-call heapify()
            if(minIdx != i) { // heap is not fixed then fix it.
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                // Thre is possiblity to other node is not satisfy the min heap property after we fix it.
                // Then re call heapify function if heap is not make perfectly.
                heapify(minIdx);
            }
        }

        // check my heap is empty or not
        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(5);

        while( !pq.isEmpty()) { // heap sort - (n logn)
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
