// ===> 0-1 Triangle pattern.

public class fifth_pattern {
    public static void zero_one_Triangle(int n) {
        // outer loop ---> for rows.
        for (int i = 1; i <= n; i++) {
            // i ---> row number 
            // j ---> cursor pointing on row

            // inner loop ---> print 0 or 1.
            for (int j = 1; j <= i; j++) {
                // if row number is odd... 
                if(i%2 == 1) {
                    // if cursor number is odd then print 1 otherwise 0.
                    if(j%2 == 1) {
                        System.out.print(1+" ");
                    }
                    else {
                        System.out.print(0+" ");
                    }
                }
                // if row number is even then...
                else {
                    // if cursor number is odd then print 0 otherwise 1.
                    if(j%2 == 1) {
                        System.out.print(0+" ");
                    }
                    else {
                        System.out.print(1+" ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        zero_one_Triangle(5);
    }
}
