/*
 * Optimize Bubble Sort:
 * Time complexity: 
 *      Worst Case: O(n^2)
 *      Best Case: O(n)            // in none optimse Best case time complexity: O(n^2)
 */

public class b_OptimizeBubbleSort {
    // modified bubble sort
    public static void modifiedBubbleSort(int arr[]) {
        for (int i = 0; i < arr.length-1; i++) {
            boolean swap = false; // initial swap is false
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true; // swap thayu che means array sorted form ma nathi
                }
            }
            if(swap == false) { // jo koi swapping nai thayu to eno matlab array sorted form ma che.
                break;
            } 
        }
    }
    public static void main(String[] args) {
        
    }
}
