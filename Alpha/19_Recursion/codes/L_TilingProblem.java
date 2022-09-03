/* (Company: Amazon)
 * Question: 11: Tailing Problem...
 * Given a "2 x n" board and tiles of size "2 x 1", count the number of ways to tile the given board using (2 x 1)  tiles.
 * (A tile can be placed horizontally or vertically.)
 */

public class L_TilingProblem {
    public static int tilingProblem(int n) { // 2 x n (floor base)
        if(n == 0 || n == 1) {
            return 1; // there is only one way insert(n == 1) tiles or not(n == 0).
        }

        // kam
        // verticale
        int fnm1 = tilingProblem(n-1);

        // horizontal
        int fnm2 = tilingProblem(n-2);

        // total ways
        int ways = fnm1 + fnm2;

        return ways;
    }
    public static void main(String[] args) {
        System.out.println(tilingProblem(1)); // 1
        System.out.println(tilingProblem(2)); // 2
        System.out.println(tilingProblem(3)); // 3
        System.out.println(tilingProblem(4)); // 5
        System.out.println(tilingProblem(5)); // 8
        System.out.println(tilingProblem(6)); // 13
        System.out.println(tilingProblem(7)); // 21
        System.out.println(tilingProblem(8)); // 34
        System.out.println(tilingProblem(9)); // 55

        // fibonacci nth number for n=1 ans = 1 , n=2 ans = 2 , n=3 ans = 3, n=4 ans = 5, ... ... ...
    }
}
