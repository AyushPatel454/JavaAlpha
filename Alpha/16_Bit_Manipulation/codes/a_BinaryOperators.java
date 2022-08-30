public class a_BinaryOperators {
    public static void main(String[] args) {
        System.out.println(5&6); // AND ----> ans: 4

        System.out.println(5|6); // OR ----> ans: 7

        System.out.println(5^6); // XOR ----> ans: 3

        System.out.println(~5); // 1's complement sum----> ans: -6 (~x = -x -1)
        System.out.println(~0); // -1
        System.out.println(~1); // -2

        System.out.println(5<<2); // left shift ---> ans: 20 [Formula: (a*2^b)]

        System.out.println(5>>2); // right shift ---> ans: 1 [Formula: (a*/^b)]
        System.out.println(6>>1); // right shift ---> ans: 3 [Formula: (a*/^b)]
    }
}