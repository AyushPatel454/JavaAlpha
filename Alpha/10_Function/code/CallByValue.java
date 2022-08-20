// ===> CALL BY VALUE...

public class CallByValue {
    public static void swap(int a, int b) {
        // swap
        int temp = a;
        a = b;
        b = temp;

        System.out.println("After SWAP...");
        System.out.println("Inside SWAP FUNCTION...");
        System.out.println("a = "+a);
        System.out.println("b = "+b);
        return;
    }
    public static void main(String[] args) {
        // Swap -values exhange
        int a = 5;
        int b = 10;
        System.out.println("Before SWAP...");
        System.out.println("a = "+a);
        System.out.println("b = "+b);

        swap(a, b);
        
        System.out.println("Outside SWAP FUNCTION (main function)...");
        System.out.println("a = "+a);
        System.out.println("b = "+b);
    }
}
