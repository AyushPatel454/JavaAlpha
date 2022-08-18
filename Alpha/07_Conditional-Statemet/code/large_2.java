import java.util.Scanner;

// ===> largest of 2
public class large_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        if(num1>num2) {
            System.out.println("Num1 is largest of 2.");
            System.out.println("Num1 >= Num2");
        }
        else {
            System.out.println("Num2 is largest of 2.");
        }
    }
}
