// Question
// Digonal Sum (only n = m. row = column)
// Company: Microsoft , Samsung , Amazon

import java.util.Scanner;

public class c_digonalSum {
    public static int digonal(int nums[][]) { // Time complexity: O(n)
        int m = nums.length-1; // total rows
        int n =  nums[0].length-1;// total column
        int sum = 0;

        // first diagonal(primary diagonal) & second diagonal(secondary Diagonal)
        for (int i = 0; i <= m; i++) {
            sum += nums[i][i];  // primary diagonal sum.
            if(i != m-i) { // if m is odd then remove center element.
                sum += nums[i][m-i];// secondary diagonal sum.
            }
            // sum += nums[i][m-i];// secondary diagonal sum.
        }
        return sum;
        // if((m+1)%2 == 0) { // if total row is even. (m = 3 but actually total row is 4. so m+1)
        //     System.out.println("Sum of Diagonal: "+sum);
        //     return sum;
        // }
        // else {
        //     int div = m/2;
        //     sum = sum - nums[div][div];
        //     System.out.println("Sum of Diagonal: "+sum);
        //     return sum;
        // }
    }
    public static void main(String[] args) {
        int nums[][] = new int[3][3];
        int m = nums.length; // total rows
        int n =  nums[0].length;// total column

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < m; i++) { // row
            for (int j = 0; j < n; j++) { // column
                nums[i][j] = sc.nextInt();
            }
        }
        System.out.println("Sum of diagonal: "+digonal(nums));
    }
}
