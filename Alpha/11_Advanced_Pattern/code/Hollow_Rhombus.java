// ===> HOLLOW RHOMBUS pattern.
//         * * * * * 
//       *       * 
//     *       * 
//   *       *
// * * * * *

public class Hollow_Rhombus {
    public static void solidRhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // space
            for (int j = 1; j <= n-i; j++) {
                System.out.print("  ");
            }
            // star
            for (int star = 1; star <= n; star++) {
                if (i==1 || i==n || star==1 || star==n) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        solidRhombus(5);
    }
}
