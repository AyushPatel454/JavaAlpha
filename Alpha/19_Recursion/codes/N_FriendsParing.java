/* (Company: GoldmanSachs)
 * Question: 13: Friends Pairing Problem.
 * Given n friends, each one remain single or can be paired up with same other friend.
 * Each friend can be paired only onece. Find out the total number ways in which friends can
 * remains single or can be paired up.
 */


public class N_FriendsParing {
    public static int friendProblem(int n) {
        // base case
        if(n == 1 || n == 2) {
            return n;
        }
        //kaam
        int single = friendProblem(n-1);
        int pair = (n-1)*friendProblem(n-2);
        int totalWays = single + pair;
        return totalWays;
    }
    public static void main(String[] args) {
        System.out.println(friendProblem(3)); // 4
        System.out.println(friendProblem(4)); // 10
    }
}
