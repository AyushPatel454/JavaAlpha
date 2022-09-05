/*
 * Question: 14: Binary String Problem:
 * Print all binary strings of size N without consecutive ones.
 * example: VALID STRINGS ---> 000 , 001 , 010 , 100 , 101 
 *          INVALID STRINGS ---> 011 , 110 , 010110
 */

public class O_PrintBinStrings {
    public static void printBinsStrings(int n, int lastPlace , String str) {
        // base case
        if(n == 0) {
            System.out.println(str);
            return;
        }

        // kaam
        // ---> optimise method (reduce line of code)
        printBinsStrings(n-1, 0, str+"0");
        if(lastPlace == 0) {
            printBinsStrings(n-1, 1, str+"1");
        }

        // ---> same like above code...
        // if(lastPlace == 0) { // if last place is 0 then we add 0 or 1.
        //     // add 0
        //     printBinsStrings(n-1, 0 , str+"0");
        //     // add 1
        //     printBinsStrings(n-1, 1 , str+"1");
        // }
        // else { // if last place is 1 then we add only 0
        //     printBinsStrings(n-1, 0, str+"0");
        // }
    }
    public static void main(String[] args) {
        System.out.println("For n = 3:");
        printBinsStrings(3, 0, ""); // stirng size is 3 , last place element set , pass empty string 
        // System.out.println("For n = 4:");
        // printBinsStrings(4, 0, ""); // stirng size is 4 , last place element set , pass empty string 
    }
}
