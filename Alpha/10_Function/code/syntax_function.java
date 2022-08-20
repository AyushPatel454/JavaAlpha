// ===> Syntax of FUNCTION

public class syntax_function {
    public static void printHelloWorld() {
        System.out.println("Hello World!");
        System.out.println("We are inside the function.");
        return; // Optional for void. Otherwise compulsory for another returntype...
    }

    public static void main(String[] args) {
        // function call...
        printHelloWorld();
    }
}
