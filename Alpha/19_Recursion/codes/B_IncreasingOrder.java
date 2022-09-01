/*
 * Problem: 2: Print numbers from n to 1. (Increasing Order.)
 */

public class B_IncreasingOrder {
    public static void printInc(int n) {
        if(n == 1) { // Base case ---> jena mate apane khabar hoy answer su hase & tya thi apde return thava nu che.
            System.out.print(n+" ");
            return; // return if n = 1 
        }
        printInc(n-1);
        System.out.print(n+" ");
    }
    public static void main(String[] args) {
        printInc(10);
    }
 }