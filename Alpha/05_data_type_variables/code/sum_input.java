import java.util.*;

public class sum_input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a , b , sum;
        System.out.print("Enter 1st number: ");
        a = sc.nextInt();
        System.out.print("Enter 2nd number: ");
        b = sc.nextInt();
        sum = a + b;
        System.out.println(sum);
    }
}
