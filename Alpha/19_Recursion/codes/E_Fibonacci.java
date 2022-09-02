/*
 * Problem: 5: Print Nth fibonacci numbers.
 * 0 1 1 2 3 5 8 13 21 34 ... ... ...
 */

public class E_Fibonacci {
    public static int fibonacci(int n) {
        if(n == 1) {
            // System.out.print((n-1)+" ");
            return 1;
        }
        if(n == 0) {
            // System.out.print((n+1)+" ");
            return 0;
        }
        int a = fibonacci(n-1); // f(2) = 1
        int b = fibonacci(n-2); // f(2) = 0
        int ans = a + b;
        // System.out.print(ans+" ");
        return ans;
    }
    public static void main(String[] args) {
        System.out.print(fibonacci(0)+" ");
        System.out.print(fibonacci(1)+" ");
        System.out.print(fibonacci(2)+" ");
        System.out.print(fibonacci(3)+" ");
        System.out.print(fibonacci(4)+" ");
        System.out.print(fibonacci(5)+" ");
        System.out.print(fibonacci(6)+" ");
        System.out.print(fibonacci(7)+" ");
        System.out.print(fibonacci(8)+" ");
        System.out.print(fibonacci(9)+" ");
        
        System.out.println();

        System.out.println(fibonacci(25));
    }
}
