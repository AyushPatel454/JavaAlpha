/* (Important Question.)
 * Question: (Medium level Question.)
 * Search in Rotated Sorted Array...
 *      Sorted, rotated array with distinct numbers (in ascending order). It is rotated
 *      at a pivot point. Find the index of given element.
 *      
 *      Example:
 *      {4,5,6,7,0,1,2} ---> Target: 0 ---> Output: 4
 */


public class C_SearchInRotatedSortedArray {
    public static int search(int arr[], int target, int si, int ei) {
        // base case
        if(si > ei) {
            return -1;
        }
        // kam
        int mid = si + (ei - si)/2;

        // case FOUND
        if(arr[mid] == target) {
            return mid;
        }

        // mid on L1
        if(arr[si] <= arr[mid]) {
            // case a: left
            if(arr[si] <= target && target <= arr[mid] ) {
                return search(arr, target, si, mid-1);
            }
            else {
                // case b : right
                return search(arr, target, mid+1, ei);
            }
        }
        
        //  mid on L2
        else {
            // case c: right
            if(arr[mid] <= target && target <= arr[ei]) {
                return search(arr, target, mid+1, ei);
            }
            else {
                // case d: left
                return search(arr, target, si, mid-1);
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int key = 0; // output ---> 4
        int tarIdx = search(arr,key,0,arr.length-1);
        System.out.println(tarIdx);
    }
}
