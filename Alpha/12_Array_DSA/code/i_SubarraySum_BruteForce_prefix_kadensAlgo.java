// print subarray maximum sum. 
// ===> Brute force (Normal method )
// ===> Prefix method
// ===> kadane's algorithm

import java.util.*; // for -infinity & +infinity

public class i_SubarraySum_BruteForce_prefix_kadensAlgo {

    // normal method ---> O(n^3) [not efficient.]
    public static void BruteForce(int arr[]) {
        int count = 0; // coount total sub array.
        int max = Integer.MIN_VALUE; 
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k]; // sum
                }
                if (max<= sum) {
                    max = sum;
                }
            }
        }
        System.out.println("Maximum of sub array sum: "+max);
    }

    // prefix mehtod ---> O(n^2) [Remeber create prefex arry]
    public static void prefix(int arr[]) {
        int max = Integer.MIN_VALUE; 
        int sum;
        int prefix[] = new int[arr.length];

        prefix[0] = arr[0];
        // calculate prefix array
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i-1]+arr[i];
        }


        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {

                sum = i == 0 ? prefix[j] : prefix[j] - prefix[i-1];

                if (max<= sum) {
                    max = sum;
                }
            }
        }
        System.out.println("Maximum of sub array sum: "+max);
    }

    // kadane's algorithm ---> O(n) [Remember when current_sum = -ve then current_sum = 0]
    public static void kadanesAlgo(int arr[]) {
        int current_sum = 0;
        int max_sum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            current_sum = current_sum + arr[i];
            if(current_sum<0) {
                current_sum = 0;
            }
            // store maximum between current_sum and max_sum in max_sum
            max_sum = Math.max(current_sum,max_sum);
        }

        System.out.println("Maximum of subarray sum: "+max_sum);
    }

    public static void main(String[] args) {
        int arr[] = {2,4,6,8,10}; // 30
        int arr2[] = {10,5,14,3,12}; // 44
        int arr3[] = {1,-2,6,-1,3}; // 8
        int arr4[] = {-2,-3,4,-1,-2,1,5,-3}; // 7

        // maxsubArraySum(arr);
        System.out.println("BRUTE FORCE:");
        BruteForce(arr2); // brute force sub array sum
        System.out.println();
        
        System.out.println("PREFIX:");
        prefix(arr3); // prefix sub array sum
        System.out.println();

        System.out.println("KADANES");
        kadanesAlgo(arr4); // 7
    }
}
