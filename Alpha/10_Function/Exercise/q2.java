/*
 * Question 2: Write a method named isEven that accepts an 
int argument. The mehod should return true if the argument 
is even, or false otherwise. Also write a program to test 
your method.
 */


import java.util.*;

public class q2 {
    public static boolean isEven(int a) {
        if(a%2 == 0) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter you num: ");
        int num = sc.nextInt();

        System.out.println("Is Even? ");
        System.out.println(isEven(num));
    }
}
