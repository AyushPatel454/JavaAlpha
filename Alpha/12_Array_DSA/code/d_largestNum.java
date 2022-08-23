// find largest number in array.

import java.util.*; // Requrire for -infinity & +infinity.


public class d_largestNum {
    // get large value of array
    public static int getLarge(int arr[]) {
        int largest = Integer.MIN_VALUE; // -infinity
        
        for (int i = 0; i < arr.length; i++) {
            if(largest<=arr[i]) {
                largest = arr[i];
            }
        }
        return largest;
    }

    // get small value of array
    public static int getSmall(int arr[]) {
        int small = Integer.MAX_VALUE; // +infinity
        
        for (int i = 0; i < arr.length; i++) {
            if(small>=arr[i]) {
                small = arr[i];
            }
        }
        return small;
    }
    public static void main(String[] args) {
        int number[] = {1,2,6,3,5};

        System.out.println("Larges value of Array: "+getLarge(number));
        System.out.println("Smallest value of Array: "+getSmall(number));
    }
}
