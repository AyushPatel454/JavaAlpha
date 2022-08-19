import java.util.Scanner;

// ===> Display all numbers enterd by user except multiple of 10.

public class multiple_10_second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter your number: ");
            int num = sc.nextInt();
            if(num%10==0) {
                continue;
            }
            System.out.println("Accepted: "+num);
        }while(true);
    }
}
