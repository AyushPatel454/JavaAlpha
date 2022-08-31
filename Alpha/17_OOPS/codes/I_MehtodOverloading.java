/*
 * Functon Overloading
 * (Compile Time Polymorphism) ---> Before the code run compiler know which function is run.
 */

public class I_MehtodOverloading {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.sum(1, 2)); // 3
        System.out.println(calc.sum(1, 2,3)); //6
        System.out.println(calc.sum(1.5f, 2.9f)); // 4.4
        System.out.println(calc.sum(1.5f, 2.5f,3.3f)); // 7.3
    }
}

class Calculator {
    int sum(int a,int b) {
        return a+b;
    }

    int sum(int a,int b,int c) {
        return a+b+c;
    }

    float sum(float a,float b) {
        return a+b;
    }

    float sum(float a,float b,float c) {
        return a+b+c;
    }
}