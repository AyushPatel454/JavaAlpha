import java.util.Scanner;

// ===> Print largest of 3.

public class large_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a , b , c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        if((a>=b) && (a>=c)) {
            System.out.println(a+" is larger.");
        }
        else if (b>=c) {
            System.out.println(b+" is lagrger.");
        }
        else {
            System.out.println(c+" is larger.");
        }
    }
}
