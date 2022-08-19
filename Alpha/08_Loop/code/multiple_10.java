import java.util.Scanner;

// ===> Keep entering numbers till user enters a multiple of 10

public class multiple_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Add number: ");
        // int check = 1;

        while(true) {
            int num = sc.nextInt();
            if(num%10 == 0) {
                break;
            }
        }

        System.out.println("This number is multiple of 10.");
        
    }
}
