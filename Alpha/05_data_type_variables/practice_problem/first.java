// Q. input3 numbers : A,B and C.You  have to output the average of these 3 numbers.

import java.util.*;

public class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        float avg = (A+B+C)/(float)3; // (A+B+C)/3f
        System.out.println(avg);        
    }
    
}
