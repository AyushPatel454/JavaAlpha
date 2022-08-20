import java.util.Scanner;

// Question 3: Write a program to find the factorialof any number entered by the user.

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int num = sc.nextInt();

        int ans = 1;
        System.out.print(num+"! = ");
        if(num == 0) {
            ans = 1;
        }
        else {
            while(num>=1) {
                ans *= num; // ans = ans * num;
                num--;   // num = num - 1;
            }
        }
        System.out.println(ans);
    }
}
