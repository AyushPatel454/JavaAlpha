import java.util.*;

// ===> IMP: Chek number is PRIME or not.
// Prime number's are ---> 2,3,5,7,11,...
// Prime number's are only divisible by 1 & te pote.

public class prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter num = ");
        int num = sc.nextInt();

        if (num == 2) {
            System.out.println(num+" is Prime.");
        }
        else {
            boolean isPrime = true;
            // for (int i = 2; i <= (num/2); i++) { ---> Take more time compare to ROOT num.
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num%i == 0) {
                    System.out.println(num+" is Non-Prime (Composite number.)");
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) { // ---> if(isPrime == true)
                System.out.println(num+" is Prime.");
            }
        }
    }
}
