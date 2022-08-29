/* (Google , Amazon)
 * Question: 3: Count Set Bits in Numbers.
 */

public class g_CountSetBits {
    public static int countSet(int n) {
        int count = 0;
        while (n>0) {
            if((n&1) == 1) { // checking LSB. (Least significant bit.)
                count++;
            }
            n = n>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countSet(8)); // 3 (111 = 7)
    }
}
