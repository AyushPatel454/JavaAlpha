/*
 * Grid Ways
 * 
 * Question: Find numbers of ways to reach from (0,0) to (N-1,M-1) in a N x M Grid.
 * 
 * Time Complexity: O( 2^(n+m) )
 */

public class E_GridWays {
    public static int gridWays(int i,int j,int n,int m) {
        // base case
        if(i == n-1 && j == m-1) {
            return 1;
        }
        else if(i == n || j == m) {
            return 0;
        }
        
        // recusionn (kaam)
        int way1 = gridWays(i+1, j, n, m);
        int way2 = gridWays(i, j+1, n, m);

        // return total ways
        return way1 + way2;
    }
    public static void main(String[] args) {
        int n = 3;
        int m = 3;

        // finding total number of ways.
        System.out.println(gridWays(0, 0, n, m));
    }
}
