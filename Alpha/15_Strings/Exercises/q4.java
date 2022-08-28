/*
 * Question 4 : Determine if 2 Strings are anagrams of each other.
 * What are anagrams ?
 * If two strings contain the same charcters but in a different order, they can be said to be 
 * anagrams. Consider race and care. In this case, race's characters can be formed into a study,
 * or care's characters can be formed into race. Below is a java program to check if two strings
 * are anagrams or not.
 * 
 * race ==== care
 * earth ==== heart
 * listen ==== silent
 */

import java.lang.reflect.Array;
import java.util.Arrays;

public class q4 {
    public static void main(String[] args) {
        String str1 = "earth";
        String str2 = "heart";

        // Convert string to lower case.
        // Why? So, that we don't have to check
        // Separately for lower & uppercase.
        str1 = str1.toLowerCase();
       str2 =str2.toLowerCase();

        // first check - if the length are the same
        if(str1.length() == str2.length()) {
            // convert strings into char Array
            char[] str1charArray = str1.toCharArray();
            char[] str2charArray = str2.toCharArray();
            // sort the char array
            Arrays.sort(str1charArray);
            Arrays.sort(str2charArray);
            // if the sorted char arrays are same or identical then the strings are anagram.
            boolean result = Arrays.equals(str1charArray, str2charArray);
            if(result) {
                System.out.println(str1 + " and " + str2 + " are anagrams of each other.");
            }
            else {
                System.out.println(str1 + " and " + str2 + " are not anagrams of each other.");
            }
        }
    }
}
