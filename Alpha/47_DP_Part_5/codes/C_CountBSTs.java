/*
 * ===> Question: 1: Counting Tree (BSTs).
 *      (Variation of Catalan's number.)
 * _____________________________________________________________________________________
 * Find number of all possible BSTs with given n nodes.
 * _____________________________________________________________________________________
 * Question: Explanation:
 * 1) n node apela hoy to ena madad thi ketla possible BSTs Tree bani sake ?
 * 2) Array apelo che to e Array na element thi ketla possible BSTs Tree bani sake ?
 * _____________________________________________________________________________________
 * Example:-
 * 1) n = 0 (Total nodes = 0)
 * Answer = 1 ---> NULL NODE.
 * 
 * 2) n = 1
 * Answer = 1
 * 
 * 3) n = 2                                             10                    20
 * Answer = 2                                             \                  /
 * Example: (10,20)                                        20               10
 * 
 * 4) n = 3
 * Answer = 5 (See notes...)
 * _____________________________________________________________________________________
 * n = 0 ----> Possible BSTs = 1                                  
 * n = 1 ----> Possible BSTs = 1                                  
 * n = 2 ----> Possible BSTs = 2                                  
 * n = 3 ----> Possible BSTs = 5                                  
 * n = 4 ----> Possible BSTs = 14                                  
 * n = 5 ----> Possible BSTs = 42
 * _____________________________________________________________________________________
 * Above Sequence is Exactly same as Catalan's Number sequence.                                  
 * _____________________________________________________________________________________
 * So, our code is also same with Catalan's number.
 * _____________________________________________________________________________________
 * Time Complexity = O(n^2)
 * _____________________________________________________________________________________
 * See notes...!!
 */


public class C_CountBSTs {
    // ---> CountBSTs/Trees = Catalan Number
    public static int countBSTs(int n) { // O(n^2)
        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) { // Ci ---> Find C2, C3, C4 , .... , Cn
            for (int j = 0; j < i; j++) { // Ci += Cj * Ci-j-1
                // dp[i] += dp[j] * dp[i-j-1];
                int leftSubTreeWays = dp[j];
                int rightSubTreeWays = dp[i-j-1];
                dp[i] += leftSubTreeWays * rightSubTreeWays;
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4; // Total number of nodes.


        System.out.println("Total possibles BSTs can make = "+countBSTs(n));
    }
}
