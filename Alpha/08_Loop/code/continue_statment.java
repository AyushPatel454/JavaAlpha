// ===> CONTINUE statment.

public class continue_statment {
    public static void main(String[] args) {
        for(int i=1; i<=5; i++) {
            // skip if i=3 (Not print 3...)
            if(i==3) {
                continue;
            }
            System.out.println(i);
        }
    }
}
