/*
 * Question: 10: Print x^n (Optimise Mehod.)
 * 2^3 = 8 like this...
 * x^n 
 * Whene n is even ---> ans = x^(n/2) * x^(n/2);
 * Whene n is odd ---> ans = x * x^(n/2) * x^(n/2);
 * 
 * Time Complexity: O(log(n))
 */

public class K_XraisToN {
    public static int power(int x,int n) {
        if(n == 0) {
            return 1;
        }
        // Below code call funstions's 2 time so Time Complexity is O(n)
        // int halfPowerSq = power(x, n/2) * power(x, n/2); // ---> Time Complexity: O(n)

        int halfPowerSq = power(x, n/2);
        halfPowerSq = halfPowerSq * halfPowerSq;

        // n is odd
        if(n % 2 != 0) {
            halfPowerSq = x *halfPowerSq;
        }

        return halfPowerSq;
    }
    public static void main(String[] args) {
        System.out.println(power(2, 3));  // 8
        System.out.println(power(2, 10));  // 1024
        System.out.println(power(3, 2));  // 9
        System.out.println(power(9, 3));  // 729
        System.out.println(power(5, 3));  // 125
        System.out.println(power(10, 3)); // 1000
    }
}
