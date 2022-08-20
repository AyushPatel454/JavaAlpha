// ===> Find Product of a & b using function.

import java.util.*;

public class product {
    // function ---> for product
    public static int product(int a, int b) {
        return a*b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter num1 = ");
        int num1 = sc.nextInt();
        System.out.print("Enter num1 = ");
        int num2 = sc.nextInt();

        int product = product(num1, num2);

        System.out.println("Product is: "+product);
    }
}
