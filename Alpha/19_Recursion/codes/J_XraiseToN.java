/*
 * Question: 9: Print x^n
 * 2^3 = 8 like this...
 * 
 * Time Complexity: O(n)
 */

public class J_XraiseToN {
    public static int power(int x,int n) {
        if(n == 0) {
            return 1;
        }
        // x = x*power(x, n-1);
        // return x;

        return x*power(x, n-1);
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
