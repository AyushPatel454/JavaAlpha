// ===> INVERTED HALF-PYRAMID with Numbers pattern.
// 1 2 3 4 5 
// 1 2 3 4 
// 1 2 3 
// 1 2
// 1

public class third_pattern {
    public static void Pyramid_num(int rows) {
        // outer loop ---> for row
        for (int i = 1; i <= rows; i++) {
            // printing nums
            for (int j = 1; j <= rows+1-i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Pyramid_num(5);
    }
}
