import java.util.Scanner;

// ===> SWITCH Statement.

public class switch_statment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        switch (number) {
            case 1:
                System.out.println("Samosa.");
                break;
            case 2:
                System.out.println("Pizza.");
                break;
            case 3:
                System.out.println("Sandwich.");
                break;
        
            default:
                System.out.println("No-thing...");
                break;
        }
    }
}
