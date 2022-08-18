// datatypes
// 1) Primitive & 2)Non-Primitive

// ===> Primitive Data-type
// byte , short , char , boolean , int , long , float , double

// ===> Non-Primitive Data-type
// String , Array , Class , Object , Interface

// Java is a typed language.[Java , c++ , python also type language.] (Apde batavu pade k keva type ni value stored karava ni che.)

public class datatypes {
    public static void main(String[] args) {
        // byte ---> byte value store karava mate. RANGE: 256 numbers only. [-128,127]
        byte b = -128;
        System.out.println(b);
        // char ---> Charachter 'a', 'b', 'c',... jevi value store karva mate.
        char ch = 'a';
        System.out.println(ch);
        // boolean ---> only store TRUE or FALSE value.
        boolean var = true;
        boolean var1 = false;
        System.out.println(var);
        System.out.println(var1);
        // float ---> Store floating value.
        float price = 10;
        System.out.println(price);
        // int ---> Store INTEGER value.
        int number = 10;
        System.out.println(number);
        // long , double ---> use for store bigger value.
        // long ---> like int. store larger int value.
        // double ---> like float. store larger floating value.
        // shor --->
        short n = 240;
        System.out.println(n);
    }
}
