public class Assignment_operator {
    public static void main(String[] args) {
        int A = 10;
        // ===> This is method is fater...
        A+=10; //  A = A + 10
        System.out.println(A); // 20

        A-=10; //  A = A - 10
        System.out.println(A); // 10

        A*=10; //  A = A * 10
        System.out.println(A); // 100

        A/=10; //  A = A / 10
        System.out.println(A); // 10

        A%=10; //  A = A % 10
        System.out.println(A); // 0
    }
}
