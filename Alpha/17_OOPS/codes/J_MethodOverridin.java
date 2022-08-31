/*
 * Functioin Overriding. (Run Time Polymorphism )
 * Parent & child classes both contain the same function with a different defination.
 */

public class J_MethodOverridin {
    public static void main(String[] args) {
        Deer objDeer = new Deer();
        objDeer.eat(); // call Dear class function eat.
    }
}

class Animal {
    void eat() {
        System.out.println("Animal eats...");
    }
}

class Deer extends Animal {
    void eat() {
        System.out.println("Deer eats...");
    }
}