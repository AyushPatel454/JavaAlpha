/*
 * Question: 2: Print All Sub-set of string.
 * "abc"
 * Subsets = 'a','b','c','ab','ac','abc','bc', ' ';
 * 
 * Total Sub-set of string = 2^n (Where, n = string length)
 * 
 * Time Complexity: O (n * 2^n) (no. of calls for find 1 Sub-set * total no. of Sub-sets)
 * Space Complexity: O (n) (Stack calls)
 */

public class B_printAllSubSet {
    public static void subSet(String str,String ans,int i) {
        // base case
        if(i == str.length()) {
            if(ans.length() == 0 ) {
                System.out.println("null");
            }
            else {
                System.out.println(ans);
            }
            return;
        }
        // Recursion (kaam)
        // Choice = Yes
        subSet(str, ans + str.charAt(i), i+1);
        // Choice = No
        subSet(str, ans, i+1);
    }
    public static void main(String[] args) {
        String str = "abc";
        subSet(str, "", 0);
    }
}
