/*
 * Question: 2: Print out the sum of the numbers in the second row of the "nums" array.
 * Example:
 * input: int[][] nums = {{1,4,9},{11,4,3},{2,2,3}};
 * output: 18
 */

public class q2 {
    public static int answer(int nums[][], int row) {
        int n = nums.length; // row
        int m = nums[0].length; // column
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += nums[row-1][i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[][] nums = {{1,4,9},{11,4,3},{2,2,3}};
        int row = 2;
        System.out.println("Sum of "+row+" row:"+ answer(nums,row));
    }
}
