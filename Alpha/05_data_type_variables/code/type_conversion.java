import java.util.Scanner;

// ===> adhuru....
/*
 * byte-->short-->int-->float-->long-->double
 */

public class type_conversion {
    public static void main(String[] args) {
        // ===> 1st
        int a = 2519;
        // convert int value into long.
        long b = a;
        System.out.println(b);

        // ===> 2nd
        long c = 2519;
        // convert long value into int. (It gives error.)
        // conversion long to int is not possiblt.
        /*
        int d = c;
        System.out.println(d); 
        */

        Scanner sc = new Scanner(System.in);
        /*
        int num = sc.nextFloat();
        (It gives error.) (Because destination size is small but source size is bigger.)
        */
        float num = sc.nextInt(); 
        // This is possible because sorce size is small and destination size is bigger.
        // Take int value input & automatically converted in float.
        System.out.println(num);
    }
}
