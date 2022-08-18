import java.util.Scanner;

/* ===> Income Tax Calculator.
    Conditions:
        income < 5L ---> 0% tax
        income between  5-10L ---> 20% tax
        income > 10L ---> 30% tax
*/

public class income_tax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long income = sc.nextLong();
        double tax; // automatically get 0

        if (income < 500000) {
            tax = 0;
            System.out.println("Tax: 0%\nTax pay = "+tax);
        }
        else if (income>=500000 && income<1000000) {
            System.out.println("Tax: 20%");
            tax = income*(0.2);
            System.out.println("Tax pay = "+tax);
        }
        else {
            System.out.println("Tax: 30%");
            tax = income*(0.3);
            System.out.println("Tax pay = "+tax);
        }
    }
}
