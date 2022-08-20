// ===> Print INVERTED-STAR pattern.
//      * * * * 
//      * * * 
//      * * 
//      *

public class inverted_star {
    public static void main(String[] args) {
        int row = 4;

        // ===> 1st method.
        for (int line = 1; line <= row; line++) {
            for (int star = 1; star <= row-line+1; star++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // ===> 2nd method.
        for (int i = row; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
