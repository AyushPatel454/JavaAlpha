// ===> DIAMOND pattern.
//         1 
//       2 1 2 
//     3 2 1 2 3 
//   4 3 2 1 2 3 4
// 5 4 3 2 1 2 3 4 5       

public class Palindromic_Pattern {
    public static void PalindromicPattern(int n) {
        for (int i = 1; i <= n; i++) {
            // space
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            // num
            for (int num = i; num >= 1; num--) {
                System.out.print(num);
            }
            // num
            for (int num = 2; num <= i; num++) {
                System.out.print(num);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        PalindromicPattern(5);
    }
}

