/*
 * Question: 1: Print the number of 7's that are in the 2d arrya.
 * Example:
 * input: int[][] array = {{4,7,8},{8,8,7}};
 * output: 2
 */

public class q1 {
    public static int answer(int nums[][],int key) {
        int n = nums.length; // row
        int m = nums[0].length; // column
        int count = 0; // initiale key is not find so count = 0.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(nums[i][j] == key) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] array = {{4,7,8},{8,8,7}};
        System.out.println("Key is found: "+ answer(array,7));
    }
}