// ===> Arithmetic operator.

public class Arithmetic_operator {
    public static void main(String[] args) {
        int A = 20;
        int B = 10;
        System.out.println("Add = "+(A+B));
        System.out.println("Sub = "+(A-B));
        System.out.println("Mul = "+(A*B));
        System.out.println("Div = "+(A/B));
        System.out.println("Mod = "+(9%5));
        System.out.println("=========================");

        // ===> UNARY Operator
        /*
         * a=a+1 ===> a++ , ++a (Increment Operator.)
         * a=a-1 ===> a-- , --a (Decrement Operator.)
         */

        /*
         * PRE-INCREMENT & PRE-DECREMENT
         * --a , ++a ---> 1) Value change. 2) Value use.
         * (Value pela change thase pachi use thase.)
         */
        int a = 10;
        int b = ++a;
        System.out.println("(a=10);\nb = ++a ===> "+b);

        int x = 20;
        int y = --x;
        System.out.println("(x=20);\ny = --x ===> "+y);
        System.out.println("=========================");
        
        /*
        * POST-INCREMENT & POST-DECREMENT
        * a-- , a++ ---> 1) Value use. 2) Value change.
        * (Value pela use thase pachi change thase.)
        */
        int c = 10;
        System.out.println("(c=10);\nc++ ===> "+c++);
        System.out.println("CHECK c ===> "+c);
        
        int p = 20;
        System.out.println("(p=20);\np-- ===> "+p--);
        System.out.println("CHECK p ===> "+p);
        System.out.println("=========================");
    }
}