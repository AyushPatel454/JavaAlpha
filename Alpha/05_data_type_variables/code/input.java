// ===> INPUT in java
/*
 * next()
 * nextLine()
 * nextInt()
 * nextLong()
 * nextFloat()
 * nextDouble()
 * nextBoolean()
 * nextByte()
 * nextShort()
 */

import java.util.*;

public class input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // next() ---> space avse to ena pachhi nu input nai le...
        // For single word input.
        // String f_name = sc.next(); 
        // input: Amy ===> OUTPUT: Amy
        // input: Amy Ash  ===> OUTPUT: Ash
        // System.out.println(f_name);
        
        // sc.nextLine();
        // Takes space's & one line only
        // To store whole name.
        // input: Amy Ash  ===> OUTPUT: Amy Ash 
        String name = sc.nextLine();
        System.out.println(name);

        // sc.nextInt();
        // Take int number as input.
        int number = sc.nextInt();
        System.out.println(number);

        // sc.nextFloat();
        // Take floating value as input
        float price = sc.nextFloat();
        System.out.println(price);

        // sc.nextBoolean();
        // Take boolean value input
        boolean bool = sc.nextBoolean();
        System.out.println(bool);
    }
}
