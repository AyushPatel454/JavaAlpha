// ===> BREAK statment.

public class break_statment {
    public static void main(String[] args) {
        // ---> If i=3 then not run loop & break it.
        for (int i=0 ; i<=5 ; i++) {
            if(i == 3) {
                break;
            }
            else {
                System.out.println(i);
            }
        }
        System.out.println("You break the loop...");
    }
}
