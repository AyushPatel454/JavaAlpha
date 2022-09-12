import java.util.Arrays;

/*
 * Question 2 : Given an array nums of size n, return the majority element. (MEDIUM)
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume
 * that the majority element always exists in the array.
 * 
 * Sample Input 1 : nums = [3,2,3]
 * Sample Output 1 : 3
 * 
 * Sample Input 2 : nums = [2,2,1,1,1,2,2]
 * Sample Output 2 : 2
 * Constraints (extra Conditions):
 * ● n == nums.length
 * ● 1 <= n <= 5 * 104
 * ● -10^9 <= nums[i] <= 10^9
 */

public class q2 {
    public static int majorityElement(int arr[]) {
        if(arr.length == 1) {
            return arr[0];
        }
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            for (int j = i; j < arr.length; j++) {
                if(arr[j] == arr[i]) {
                    temp++;
                    if(temp > (arr.length)/2) {
                        return arr[i];
                    }
                }
                else {
                    i = j - 1;
                    break;
                }                
            }
        }
        return -1;   
    }
    public static void main(String[] args) {
        int arr[] = {2,3,2};
        int ans = majorityElement(arr);
        System.out.println(ans);
    }
}
