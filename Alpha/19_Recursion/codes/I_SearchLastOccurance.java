/*
 * Problem: 8: Write a function to find the first occurence of an element in an array.
 */

public class I_SearchLastOccurance {
    public static int searchKey(int arr[],int i,int key) {
        if(key == arr[arr.length-1-i]) { // compare to last element's not compare with starting elements. If last element is found then return last index which is arr.length-1-i
            return arr.length-1-i;
        }
        if(i == arr.length-1) {
            return -1;
        }
        return searchKey(arr, i+1, key);
    }
    public static void main(String[] args) {
        int arr[] = {8,3,6,9,5,10,2,5,9};
        // finding first occurance of 9
        System.out.println(searchKey(arr, 0, 33)); // 8
    }
}
