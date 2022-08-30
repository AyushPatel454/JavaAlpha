/*
 * Question: 2: Swap two number without using any third variable.
 */

public class q2 {
    public static void main(String[] args) {
        int a = 2; // 010 ---> Binary.
        int b = 3; // 011 ---> Binary.

        System.out.println("Before...\na = "+a+"\tb = "+b);
        // method one
        // a = a + b; // a = 2 + 3 = 5
        // b = a - b; // b = a - b = 5 - 3 = 2
        // a = a - b; // a = a - b = 5 - 2 = 3
        
        // 2nd method using bit wise XOR
        // Binary 
        a = a ^ b; // a = 010 ^ 011 = 001 (1)
        b = a ^ b; // a = 001 ^ 011 = 010 (2)
        a = a ^ b; // a = 001 ^ 010 = 011 (3)

        System.out.println("After...\na = "+a+"\tb = "+b);
    }
}
