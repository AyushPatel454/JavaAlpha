// ===> NUMBER PYRAMID pattern.
//     1 
//    2 2
//   3 3 3
//  4 4 4 4
// 5 5 5 5 5

public class Number_Pyramid {
    public static void NumberPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            // space
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            // num
            for (int num = 1; num <= i; num++) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        NumberPyramid(5);
    }
}
