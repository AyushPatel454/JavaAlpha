/*
 * Question: 2: Check if a number is a Power of 2 or not.
 */

public class f_PoweOf2 {
    public static boolean Poweroftwo(int n) {
        // ===> My method.
        // for (int i = 0; i <= Math.sqrt(n); i++) {
        //     if(n == 1<<i) {
        //         return true;
        //     }
        // }
        // return false;

        // apna college mthod.
        return (n&(n-1)) == 0;
    }
    public static void main(String[] args) {
        System.out.println(Poweroftwo(16));
    }
}
