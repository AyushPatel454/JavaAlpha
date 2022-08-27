// Question
// ===> Spiral Matrix.
// Company: Microsoft , Samsung , Amazon
/*
    _           _
 * |1   2  3  4 |        *OUTPUT*
 * |5   6  7  8 |   ===> 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 * |9  10 11 12 |
 * |13 14 15 16 |
 * _           _
 */

import java.util.Scanner;

public class b_spiral {
    public static void spiral(int nums[][]) {
        int m = nums.length-1; // total rows
        int n =  nums[0].length-1;// total column
        int min = Math.min(m, n);
        for (int i = 0; i <= min/2; i++) {
            int j = i , k = i; // j--->column , k---> row
            while(j<=(n-i)) {
                System.out.print(nums[k][j]+" ");
                j++;
            }
            k++;
            j--;
            while(k<=(m-i)) {
                System.out.print(nums[k][j]+" ");
                k++;
            }
            k--;
            j--;
            while(j>=i) {
                if(i == m-i) {
                    break;
                }
                System.out.print(nums[k][j]+" ");
                j--;                
            }
            k--;
            j++;
            while(k>i) {
                if(j == n-i) {
                    break;
                }
                System.out.print(nums[k][j]+" ");
                k--;                
            }
        }
    }
    public static void main(String[] args) {
        int nums[][] = new int[4][4];
        int m = nums.length; // total rows
        int n =  nums[0].length;// total column

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < m; i++) { // row
            for (int j = 0; j < n; j++) { // column
                nums[i][j] = sc.nextInt();
            }
        }
        spiral(nums);
    }
}
