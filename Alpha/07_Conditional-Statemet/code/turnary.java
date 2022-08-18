import java.util.Scanner;

// ===> Turnary Operator...
/*
 * Check odd or even...
 */

public class turnary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 4;
    
        // ternary operator
        String type = ((number%2) == 0) ? "even" : "odd";
    
        System.out.println(type);     
        
        // check student is pass or not...
        int marks = sc.nextInt();
        String report_card = (marks>=33) ? "Pass" : "Fail";
        System.out.println(report_card);
    }
}
