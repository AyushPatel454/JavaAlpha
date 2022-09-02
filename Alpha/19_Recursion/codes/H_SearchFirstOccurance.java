/*
 * Problem: 7: Write a function to find the first occurence of an element in an array.
 */

public class H_SearchFirstOccurance {
    public static int searchKey(int arr[],int i,int key) {
        if(arr[i] == key) {
            return i;
        }
        if(i == arr.length-1) {
            return -1;
        }
        return searchKey(arr, i+1, key);
    }
    public static void main(String[] args) {
        int arr[] = {8,3,6,9,5,10,2,5,9};
        // finding first occurance of 9
        System.out.println(searchKey(arr, 0, 9)); // 3
    }
}
