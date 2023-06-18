// ===> Convert from Decimal to Binary.

import java.util.*;
public class DecimalToBinary {

    public static int DecimalToBinary(int decNum) {
        int binNum = 0 , rem , power = 0;
        while(decNum >   0) {
            rem = decNum % 2;
            binNum = binNum + (rem*(int)Math.pow(10, power));
            power++;
            decNum /= 2;
        }
        return binNum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter decimal num = ");
        int n = sc.nextInt();

        int ans = DecimalToBinary(n);

        System.out.println("Binary number: "+ans);
    }
}
