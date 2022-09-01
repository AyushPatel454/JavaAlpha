/*
 * Problem: 1: Print numbers from n to 1. (Decreasing Order.)
 */

 public class A_DecreasingOrder {
    public static void printDec(int n) {
        if(n == 1) { // Base case ---> jena mate apane khabar hoy answer su hase & tya thi apde return thava nu che.
            System.out.print(n+" ");
            return; // return if n = 1 
        }
        System.out.print(n+" ");
        printDec(n-1);
    }
    public static void main(String[] args) {
        printDec(10);
    }
 }