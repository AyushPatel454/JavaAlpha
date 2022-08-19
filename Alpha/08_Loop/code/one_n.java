import java.util.Scanner;

// ===> Print 1 to n number. using while loop.

public class one_n {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n = ");
        int n = sc.nextInt();

        int counter = 1;
        
        while (counter <= n) {
            System.out.print(counter+" ");
            counter++;
        }
        System.out.println();
    }    
}
