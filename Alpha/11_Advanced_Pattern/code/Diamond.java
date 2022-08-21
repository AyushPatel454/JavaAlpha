// ===> DIAMOND pattern.
//         * 
//       * * * 
//     * * * * * 
//   * * * * * * *
// * * * * * * * * *
// * * * * * * * * *
//   * * * * * * *
//     * * * * *
//       * * *
//         *

public class Diamond {
    public static void diamond(int n) {
        // 1st Half pattern
        for (int i = 1; i <= n; i++) {
            // space
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            // star
            for (int star = 1; star <= (i*2)-1; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 2nd Half pattern
        for (int i = n; i >= 1; i--) {
            // space
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            // star
            for (int star = 1; star <= (i*2)-1; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        diamond(5);
    }
}
