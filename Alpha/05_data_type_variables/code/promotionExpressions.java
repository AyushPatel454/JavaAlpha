public class promotionExpressions {
    public static void main(String[] args) {
        byte a = 52;
        short b = 5;
        char c = 'g';
        // byte bt = a + b + c; //it is not possible because all data type converts value in int.
        //required to type cast int in to byte.
        byte bt = (byte) (a + b + c);
        System.out.println(bt);

        // same for int,long,float,double

        int n1 = 56;
        long n2 = 245;
        float n3 = 25.19f;
        double sum = n1 + n2 + n3; //All int long , float value converted in to double automatically
        System.out.println(sum);

        byte be = 5;
        // be = 2* be;  //can not make change directly in to byte because byte represt in int so 1st convert int in to byte using type casting... 
        be = (byte) (2* be);
        System.out.println(be);



    }
    
}
