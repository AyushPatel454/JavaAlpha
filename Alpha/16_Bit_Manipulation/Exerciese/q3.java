/*
 * Question:3: Add 1 to an integar using Bit Manipulation.
 * (Hint: Try using Bitwise NOT Operator)
 */

public class q3 {
    public static void main(String[] args) {
        // ~x = -x - 1 = -(x + 1)
        // -~x = -(-(x + 1)) = x + 1
        System.out.println("5 + 1: -~(5): "+(-~(5)));
        System.out.println("0 + 1: -~(0): "+(-~(0)));
        System.out.println("-2 + 1: -~(-2): "+(-~(-2)));
    }
}