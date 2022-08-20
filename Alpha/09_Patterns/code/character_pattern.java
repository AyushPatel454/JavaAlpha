// ===> Print CHARACTER pattern.
//      A 
//      B C
//      D E F
//      G H I J

public class character_pattern {
    public static void main(String[] args) {
        // ===> using ASCII number. (My mehtod.)

        // int row = 4;
        // int ch = 65; // ASCII of A-Z = 65 to 90
        // // System.out.println((char)(65)); //---> convert int to char.

        // for (int line = 1; line <= row; line++) {
        //     int j = 1;
        //     while (j<=line) {
        //         System.out.print((char)ch +" ");
        //         ch++;
        //         j++;
        //     }
        //     System.out.println();
        // }


        // Easy method. (Apna College)
        int n = 4;
        char ch = 'A';

        // outer loop
        for (int line = 1; line <= n; line++) {
            // inner loop
            for (int chars = 1; chars <= line; chars++) {
                System.out.print(ch + " ");
                ch++; // increase character (example: 'A'+1 = 'B')
            }
            System.out.println();
        }
    }
}
