/*
 * Question 3 : Write a program to find Length of a String using Recursion.
 */

public class q3 {
    public static int subString(String str, int n, String newStr) {
        int count = 0;
        if(n == str.length()) {
            return count;
        }
        newStr = newStr+str.charAt(n);
        if(newStr.charAt(0) == newStr.charAt(newStr.length()-1)) {
            count++;
        }
        count = count + subString(str, n+1, newStr);

        newStr = "";
        if(n+1 == str.length()) {
            return count;
        }
        // newStr = newStr + str.charAt(n+1);
        // count = count + subString(str, n+1, newStr);
        newStr = newStr + str.charAt(n+1);
        count = count + subString(str, n+1, newStr);
        

        return count;
    }
    public static void main(String[] args) {
        int ans = subString("aaa", 0, "");
        System.out.println(ans);
    }
}
