import javax.sql.RowSet;

// ===> Invarted Rotate Half-Pyramid.
//            *
//          * *
//        * * *
//      * * * *

public class InvartedRotateHalf_Pyramid {
    public static void Half_Pyramid(int rows) {
        // outsider loop ---> for rows.
        for (int i = 1; i <= rows; i++) {

            // space
            for (int space = 1; space <= rows-i; space++) {
                System.out.print("  ");
            }

            // star
            for (int star = 1; star <= i; star++) {
                System.out.print("* ");
            }
            System.out.println(); // new line.
        }
    }
    public static void main(String[] args) {
        Half_Pyramid(4);
    }
}