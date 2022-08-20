// Nested Loop
// ===> Print STAR patterm
//      * 
//      * * 
//      * * * 
//      * * * *

public class star_pattern_nested_loop {
    public static void main(String[] args) {
        int row = 4;

        // First loop ---> for create ROW
        for (int i = 1; i <= row; i++) {
            // Inner loop ---> for printing *
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println(); // Create next line.
        }
    }
}
