/*
 * ===> Question: 2: Mountain Ranges.
 *      (Variation of Catalan's number.)
 * _____________________________________________________________________________________
 * You given total number of pairs contain upstroke ('/') and downstroke ('\').
 * You need to count possible numebr of mountain ranges.
 * 
 * Mountain & valley at any moment the number of down strokes can not be more than number of upstroke.
 * _____________________________________________________________________________________
 * Example:-
 *                  ********For understand Examples see notes...!!********
 * 1) pairs = 0
 * Answer = 1 (Default for 0)
 * 
 * 2) pairs = 1
 * Possible mountain ranges = 1
 * 
 * 3) pairs = 2
 * Possible mountain ranges = 2
 * 
 * 4) paris = 3
 * Possible mountain ranges = 5 
 * 
 * 5) paris = 4
 * Possible mountain ranges = 14
 * _____________________________________________________________________________________
 * n = 0 ----> Possible mountain ranges = 1                                  
 * n = 1 ----> Possible mountain ranges = 1                                  
 * n = 2 ----> Possible mountain ranges = 2                                  
 * n = 3 ----> Possible mountain ranges = 5                                  
 * n = 4 ----> Possible mountain ranges = 14                                  
 * n = 5 ----> Possible mountain ranges = 42
 * _____________________________________________________________________________________
 * Above Sequence is Exactly same as Catalan's Number sequence.                                  
 * _____________________________________________________________________________________
 * So, our code is also same with Catalan's number.
 * _____________________________________________________________________________________
 * Time Complexity = O(n^2)
 * _____________________________________________________________________________________
 * See notes...!!
 */


public class D_MountainRanges {
    // ---> CountBSTs/Trees = Catalan Number
    public static int mountainRanges(int n) { // O(n^2)
        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) { // Mi ---> Find M2, M3, M4 , .... , Mn
            for (int j = 0; j < i; j++) { // Mi += Mj * Mi-j-1
                // dp[i] += dp[j] * dp[i-j-1];
                int insideMountains = dp[j];
                int outSideMountains = dp[i-j-1];
                dp[i] += insideMountains * outSideMountains;
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4; // Total number of nodes.


        System.out.println("Total possibles Mountain Ranges = "+mountainRanges(n));
    }
}
