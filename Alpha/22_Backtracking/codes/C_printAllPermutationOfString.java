/*
 * Question: 3: Find Permutation (Permutation = Arrangment)
 *              Find and print all permutations of a string.
 * 
 * "abc"
 * Permutation/Arrangment = 'abc','acb','bac','bca','cab','cba'
 * 
 * Total Permutation of string = n! (Where, n = string length)
 * 
 * Time Complexity: O (n * n!) (no. of calls for find 1 permutation * total permutation)
 * Space Complexity: O (n) (Stack Calls)
 */

public class C_printAllPermutationOfString {
    // permutation 
    public static void findPermutation(String str,String ans) {
        // base case
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // recurssion (kaam) - O(n*n!)
        for (int i = 0; i < str.length(); i++) {
            // char curr =  str.charAt(i);
            // "abcde" => .substring(0,2) + .substring(3) => "ab" + "de" = "abde"
            String NewStr = str.substring(0, i) + str.substring(i+1);
            findPermutation(NewStr, ans+str.charAt(i));
        }
    }
    public static void main(String[] args) {
        String str = "abc";
        findPermutation(str, "");
    }
}
