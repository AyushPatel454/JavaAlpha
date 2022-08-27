/*
 * Question: 3: Write a program to find TRANSPOSE of a Matrix.
 * What is TRANSPOSE? ---> Transpose of a matrix is the process of swapping the rows to columns. 
 * 
 * For a 2x3 matrix,
 * MATRIX:
 * a11 a12 a13
 * a21 a22 a23
 * 
 * TRANSPOSE MATRIX:
 * a11 a21
 * a12 a22
 * a13 a23
 */

public class q3 {
    public static int[][] answer(int nums[][]) {
        int n = nums.length; // row ---> 2
        int m = nums[0].length; // column ---> 3
        int copy[][] = new int[m][n]; // copy[3][2]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[j][i] = nums[i][j];
            }
        }
        return copy;
    }
    public static void display(int nums[][]) {
        int n = nums.length; // row ---> 2
        int m = nums[0].length; // column ---> 3
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] nums = {{1,4,9},{11,4,3},{2,2,3}};
        System.out.println("MATRIX:");
        display(nums);

        System.out.println("TRANSPOSE-MATRIX:");
        nums = answer(nums);
        display(nums);
    }
}
