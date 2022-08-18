public class typecasting {
    public static void main(String[] args) {
        float a = (float)25.19;
        // float a = 25.19f;
        //  there are two methods for covert double value in to float

        // converting float into int.
        int b = (int) a; // int b = a ---> is give error.
        System.out.println(b); // 25

        //converting character to number.
        char ch = 'a';
        int number = ch;
        // int number = (int)ch; ---> same as above
        System.out.println(number); //charater converted in to number but it number ASCII value of number
    }
    
}
