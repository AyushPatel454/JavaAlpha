/*
 * Question 3 : Write a program to find Length of a String using Recursion.
 */

public class test {
    public static int subString(String str, int n, String newStr) {
        int count = 0;
        if(n == str.length()) {
            return count;
        }
        
        newStr = newStr+str.charAt(n);
        String innerStr = "" + str.charAt(n);
        if(newStr.charAt(0) == newStr.charAt(newStr.length()-1)) {
            count++;
        }
        if(innerStr.charAt(0) == innerStr.charAt(innerStr.length()-1) && n>0) {
            count++;
        }

        if (n>0) {
            count = count + subString(str, n+1, innerStr);
        }
        
        count = count + subString(str, n+1, newStr);

        // newStr = "";
        // if(n+1 == str.length()) {
        //     return count;
        // }
        // // newStr = newStr + str.charAt(n+1);
        // // count = count + subString(str, n+1, newStr);
        // newStr = newStr + str.charAt(n+1);
        // count = count + subString(str, n+1, newStr);
        

        return count;
    }
    public static void main(String[] args) {
        int ans = subString("aba", 0, "");
        System.out.println(ans);
    }
}
