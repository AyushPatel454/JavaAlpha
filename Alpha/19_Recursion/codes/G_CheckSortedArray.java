/*
 * Problem: 6: Check the given array is sorted or not.
 * | 1 | 2 | 3 | 4 | ---> true
 * | 1 | 2 | 3 | 4 | 3 | ---> false
 */

public class G_CheckSortedArray {
    public static int n;
    public static int check;

    public static boolean isSort(int[] arr,int i) {
        if(i == arr.length-1) {
            return true;
        }
        if(arr[i] > arr[i+1]) {
            return false;
        }

        return isSort(arr, i+1);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};      // sorted
        System.out.println(isSort(arr, 0)); // true
        int arr2[] = {1,2,3,4,3};   // unsorted
        System.out.println(isSort(arr2, 0)); // false
    }    
}