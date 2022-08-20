// ===> Print HALF-PYRAMID pattern.
//      1 
//      1 2 
//      1 2 3 
//      1 2 3 4

public class half_pyramid {
    public static void main(String[] args) {
        int row = 4;

        // Outer loop ---> for create line 
        for (int line = 1; line <= row; line++) {
            // Inner loop ---> for print number
            for (int num = 1; num <= line; num++) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}
