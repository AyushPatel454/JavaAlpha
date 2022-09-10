/*
 * Question:1: Backtracking Array
 */

 public class A_BackTrackingArray {
    public static void changeArray(int arr[],int i,int val) {
        // base case
        if(i == arr.length) {
            printArr(arr);
            return;
        }

        // recursion (kaam)
        arr[i] = val;
        changeArray(arr, i+1, val+1);
        arr[i] -= 2; 
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = new int[5];
        changeArray(arr, 0, 1);
        printArr(arr);
    } 
 }