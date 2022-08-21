/*
 * Question 4: READ & CODE EXERCISSE
 * Search about (Google) & use the following method of 
 * Math class in Java:
 * a) Math.min();  ---> use for find MINIMUM of 2.              
 * b) Math.max();  ---> use for find MAXIMUM of 2.              
 * c) Math.sqrt(); ---> use for find SquareRoot of num.               
 * d) Math.pow();  ---> use for find POWER of num.              
 * e) Math.avg();  ---> 
 * f) Math.abs();  ---> use for find ABSOLUTE of num.              
 */


import java.util.*;

public class q4 {
    public static void main(String[] args) {
        int num = 10; 
        // Math.min() ---> Take 2 Argument. Type int.
        System.out.println("Math.min(20,30) = "+Math.min(20, 30));

        // Math.max() ---> Take 2 Argument. Type int.
        System.out.println("Math.max(20,30) = "+Math.max(20, 30));

        // Math.sqrt() ---> Take 1 Argument. Type double.
        System.out.println("Math.sqrt(4) = "+Math.sqrt(4));

        // Math.pow() ---> Take 2 Argument. Type double.
        System.out.println("Math.pow(4,2) = "+Math.pow(4,2));

        // Math.avg() ---> There is no method for this in Java.

        // Matabs() ---> Take 1 Argument. Type int.(also take floating value.)
        System.out.println("Math.abs(-1925) = "+Math.abs(-1925));
    }
}
