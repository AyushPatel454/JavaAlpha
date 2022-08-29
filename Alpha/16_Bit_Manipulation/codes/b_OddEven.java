public class b_OddEven {
    public static void oddOrEven(int n) {
        int bitMask = 1;
        if((n & bitMask) == 0) {
            // even number.
            System.out.println("Even number.");
        }
        else {
            // odd number.
            System.out.println("Odd number.");
        }

    }
    public static void main(String[] args) {
        oddOrEven(4);  // even
        oddOrEven(12);  // even
        oddOrEven(3);  // odd
        oddOrEven(9);  // odd
        oddOrEven(5);  // odd
        oddOrEven(13);  // odd
    }
}
