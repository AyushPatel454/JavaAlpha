import java.util.Scanner;

// ===> Parameter of function.
// Add 2 numbers using function.

public class addNum_parameter {
    // Function
    public static int calculateSum(int a,int b) { // Parameter or formal parameter
        int sum = a + b;
        return sum; // return the value of sum.
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        // return value of function is store in ans variable.
        int ans = calculateSum(num1, num2); // argument or actual parameter

        System.out.println("Sum of 2 number is: "+ans);
    }
}
