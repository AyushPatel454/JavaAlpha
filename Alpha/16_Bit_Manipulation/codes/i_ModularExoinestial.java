/*
 * Modular Exponestial. a^b % x
 */

public class i_ModularExoinestial {
    public static void main(String[] args) {
        int a = 3 , b = 5, mod = 7;
        int ans = 1;

        while (b>0) {
            if((b&1) == 1) {
                ans = ans * a;
            }
            a = a*a;
            b = b>>1;
        }
        System.out.println(ans%mod);
    }
}
