import java.util.Scanner;

// Create CALCULATOR
// +,-,*,/,%

public class calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double ans;

        System.out.println("Enter number one: ");
        int num1 = sc.nextInt();

        System.out.println("Enter number two: ");
        int num2 = sc.nextInt();

        System.out.println("Enter operator: ");
        char operator = sc.next().charAt(0);

        switch (operator) {
            case '+':
                ans = num1+num2;
                System.out.println(num1+ " " +operator+ " " +num2+ " = "+ans);
                break;
            case '-':
                ans = num1-num2;
                System.out.println(num1+ " " +operator+ " " +num2+ " = "+ans);
                break;
            case '*':
                ans = num1*num2;
                System.out.println(num1+ " " +operator+ " " +num2+ " = "+ans);
                break;
            case '/':
                ans = (double)num1/num2;
                System.out.println(num1+ " " +operator+ " " +num2+ " = "+ans);
                break;
            case '%':
                ans = num1%num2;
                System.out.println(num1+ " " +operator+ " " +num2+ " = "+ans);
                break;
        
            default:
                System.out.println("You press wrong key for operand...!!");
                break;
        }
    }
}
