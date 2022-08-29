public class d_ClearLastBit {
    public static int clearIthBits(int n, int i) {
        int bitMask = (~0)<<i; // -1<<i
        return n&bitMask;
    }
    public static void main(String[] args) {
        System.out.println(clearIthBits(15, 2)); // 1111 & 1100 ---> 1100 (12)
    }
}
