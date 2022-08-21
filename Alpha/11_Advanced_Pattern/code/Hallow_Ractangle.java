// ===> Hallow Ractangle.
//      * * * 
//      *   * 
//      *   * 
//      *   *
//      * * *

public class Hallow_Ractangle {
    public static void HallowRactangle(int rows,int cols) {
        // outer loop ---> for row.
        for (int i = 1; i <= rows; i++) {
            // inner loop ---> printing *
            for (int j = 1; j <= cols; j++) {
                // i , j ---> current row , current column
                if(i==1 || i==rows || j==1 || j==cols) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println(); // create new line.
        }
    }
    public static void main(String[] args) {
        HallowRactangle(5, 3);
    }
}