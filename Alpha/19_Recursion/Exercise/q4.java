/*
 * Question 4 :  We are given a string S, we need to find the count of all contiguous substrings
 * starting and ending with the same character.
 * 
 * Sample Input 1 : S = "abcab"
 * Sample Output 1 : 7
 * There are 15 substrings of "abcab" : a, ab, abc, abca, abcab, b, bc, bca, bcab, c, ca, cab, a, ab, b
 * Out of the above substrings, there are 7 substrings : a, abca, b, bcab, c, a and b. So, only 7
 * contiguous substrings start and end with the same character.
 * 
 * Sample Input 2 : S = "aba"
 * Sample Output 2 : 4
 * The substrings are a, b, a and aba.
 */

public class q4 {
    // subString count
    public static int subString(String str,int n,String newStr){
        int count = 0;

        if(n == str.length()) {
            return count;
        }
        if(newStr == "") {
            count = subString(str, n+1, newStr);
        }

        newStr = newStr + str.charAt(n);
        
        if(newStr.charAt(0) == newStr.charAt( newStr.length() - 1 )) {
            count++;
        }

        count = count + subString(str, n+1, newStr);

        return count;
    }

    public static void main(String[] args) {
        // System.out.println("aba".length()); // 3
        int x = subString("abcab", 0, "");
        System.out.println(x); //7
        int y = subString("aba", 0, "");
        System.out.println(y); // 4
        int ans = subString("aa", 0, "");
        System.out.println(ans); // 3
        int ans2 = subString("aaa", 0, "");
        System.out.println(ans2); // 6
        int ans3 = subString("aab", 0, "");
        System.out.println(ans3); // 4
    }
}
