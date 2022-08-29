public class h_fastExponestial {
    public static int fastExpo(int a,int n) {
        int ans = 1;
        while (n>0) {
            if( (n&1) == 1) { // Checking LSB. (Least significant bit.)
                ans = ans * a;
            }
            a = a * a;
            n = n>>1; // till n becomes 0;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(fastExpo(3, 5)); // 243
        System.out.println(fastExpo(5, 3)); // 125
    }
}
