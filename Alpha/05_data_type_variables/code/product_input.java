import java.util.Scanner;

public class product_input {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int a , b , product;

        System.out.print("Enter 1st number: ");
        a = obj.nextInt();
        System.out.print("Enter 2nd number: ");
        b = obj.nextInt();

        product = a*b;
        System.out.println(product);
    }
}
