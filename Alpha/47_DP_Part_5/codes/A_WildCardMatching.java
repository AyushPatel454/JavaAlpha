/*
 * ===> Question: 1: Wildcard Matching
 * ________________________________________________________________________
 * Variation of LCS (Longest Common Subsequence.)
 * ________________________________________________________________________
 * Given a text & a wildcard pattern , implement wildcard pattern matching algorithmthat finds if wildcard pattern is matched with text.The matching should cover the entire text (not partial text).
 * The wildcard pattern can inculde the charachters '?' and '*'
 *  ---> '?' ---> Matches any single charachter.
 *  ---> '*' ---> Matches any sequence of multiple charachter (inculding the empty sequence).
 * ________________________________________________________________________
 * Examples:-
 * 1) s = "abc" , pattern = "a?c"
 * Answer = True.
 * 
 * 2) s = "ab" , p = "?b"
 * Answer = True.
 * 
 * 3) s = "ab" , p = "?"
 * Answer = False.
 * 
 * 4) s = "ab" , p = "?**" -----> '?' = 'a' , '*' = b ,'*' = ''
 * Answer = True.
 * 
 * 5) s = "baa" , p = "aa*" (1st charachter not match.)
 * Answer = False.
 * ________________________________________________________________________
 * Time Complexity = O(n * m)
 * ________________________________________________________________________
 * See notes for better understanding...!!
 */

public class A_WildCardMatching {
    public static boolean isMath(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n+1][m+1];

        // Inilize with base case.
        dp[0][0] = true; // s = '' & p = '' (Both empty then it's match. True)

        // s.length > 0 & p.length = 0
        for (int i = 1; i < n+1; i++) {
            dp[i][0] = false;
        }

        // s.length = 0 & p.length > 0
        for (int i = 1; i < m+1; i++) {
            if(p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-1];
            } else { // '?' or 'charachter'
                dp[0][i] = false;
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1) == '*'){
                    // 2 case.
                    // 1) Ignore star.
                    boolean ignoreStar = dp[i][j-1];
                    // 2) Add star.
                    boolean matchStar = dp[i-1][j];

                    dp[i][j] = ignoreStar || matchStar;
                } else { // 'charachter'
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        // String word = "baaabab";
        // String pattern = "******ba*****ab"; // true.
        String word = "ab";
        String pattern = "a?b"; // true.
        System.out.println(isMath(word, pattern));
    }
}
