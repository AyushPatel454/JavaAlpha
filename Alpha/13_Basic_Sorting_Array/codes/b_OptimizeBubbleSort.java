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

    // Display array
    public static void displayArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9}; // This is best case: Time Complexity: O(n)
        modifiedBubbleSort(arr);
        displayArray(arr);
        int arr2[] = {9,8,7,6,5,4,3,2,1}; // This is Worsr case: Time Complexity: O(n^2)
        modifiedBubbleSort(arr2);
        displayArray(arr2);
    }
}
