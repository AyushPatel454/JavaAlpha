// ===> BUTTERFLY pattern.
// *             *   
// * *         * *   
// * * *     * * *   ===> 1st half loop
// * * * * * * * *   ____________________
// * * * * * * * *   
// * * *     * * *   ===> 2nd half loop
// * *         * *   
// *             *   

public class butterfly_pattern {
    public static void Butterfly(int n) {
        // 1st half loop...
        for (int i = 1; i <= n; i++) {
            // star
            for (int star = 1; star <= i; star++) {
                System.out.print("*");
            }
            // space
            for (int j = 1; j <= 2*(n-i); j++) {
                System.out.print(" ");
            }
            // star
            for (int star = 1; star <= i; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 2nd half loop...
        for (int i = n; i >= 1; i--) {
            // star
            for (int star = 1; star <= i; star++) {
                System.out.print("*");
            }
            // space
            for (int j = 1; j <= 2*(n-i); j++) {
                System.out.print(" ");
            }
            // star
            for (int star = 1; star <= i; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Butterfly(4);
    }
}
