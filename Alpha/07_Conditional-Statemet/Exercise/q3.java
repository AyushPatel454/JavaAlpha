import java.util.Scanner;

/*
 * Question3:Write a Java program to input weeknumber (1-7) and print day of week name using switch case.
 */

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int week_num;

        System.out.print("Enter week number (1-7):");
        week_num = sc.nextInt();

        switch(week_num) {
            case 1: System.out.println("Sunday");
                    break;
            case 2: System.out.println("Monday");
                    break;
            case 3: System.out.println("Tuesday");
                    break;
            case 4: System.out.println("Wednesday");
                    break;
            case 5: System.out.println("Thursday");
                    break;
            case 6: System.out.println("Friday");
                    break;
            case 7: System.out.println("Saturday");
                    break;
            default: System.out.println("There is only 1-7 week's day.");
        }
    }
}
