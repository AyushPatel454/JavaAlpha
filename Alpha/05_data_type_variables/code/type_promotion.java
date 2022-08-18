public class type_promotion {
    public static void main(String[] args) {
        char a = 'a';
        char b = 'b';
        // char c = b - a ---> ERROR (a-b is now int but we can't convert int to char.)

        System.out.println(b-a); // 98 - 97 = 1
        
        /*
            System.out.println(a);       ----> a
            System.out.println(b);       ----> b   
            System.out.println((int)a);  ----> 97  
            System.out.println((int)b);  ----> 98
         */

         short x = 5;
         byte y = 25;
         char z = 'c';
        //  System.out.println(x+y+z); ---> 129
        /*
            byte bt = x + y + z; ---> ERROR
            Cuse x+y+z is now become int. We cant int value in byte.
            Cuse int size has 4bytes & byte size has 2bytes.
        */
        byte bt = (byte)(x+y+z);
        System.out.println(bt); // no sense...
        System.out.println(1+1.0);

        // ==================== //
        int p = 10;
        float q = 20.25f;
        long r = 25;
        double s = 19;
        double ans = p + q + r + s;
        /* Above expression all operator (p,q,r,s) converted into double...
         * because the largest datatype of expression is double.
         * So, p+q+r+s ---> Ans in DOUBLE form.
         * So, We store Ans in double datatype.
         * 
         * OTHERWISE
         * int ans = p+q+r+s ---> ERROR
         * Cause, (p+q+r+s) ----> DOUBLE & ans ----> INT
         */
        System.out.println(ans);

        // ======================= //
        byte g = 9;
        // byte h = g*2; ---> ERROR Cuse it is expression and 2 is int so our ans in form in INT. We can't store in BYTE.
        byte h = (byte)(g*2);
        System.out.println(h); // 18
    }
}
