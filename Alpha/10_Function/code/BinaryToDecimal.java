// ===> Convert from Binary to Decimal.

import java.util.*;
public class BinaryToDecimal {

    public static int BinaryToDecimal(int a) {
        int decNum = 0 , power = 0 , last_digit;
        while(a>=1) {
            last_digit = a%10;

            if(last_digit != 1 && last_digit != 0) {
                return -1; // for this not binary number.
            }

            decNum += last_digit*(int)Math.pow(2, power); // bydefault pow return double.
            power++;
            a /= 10;
        }
        return decNum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter binary num = ");
        int n = sc.nextInt();

        int ans = BinaryToDecimal(n);

        if(ans == -1) {
            System.out.println("This is not binary number!!");
        }
        else {
            System.out.println("Decimal number: "+ans);
        }
    }
}
