/*
 * Abstraction Classes.
 * Abstraction classes method.
 * Constructor calling heriachly
 */

public class L_Abstract {
    public static void main(String[] args) {
        Horse h = new Horse(); // call Animal constructor then horse constructor.
        h.eat();
        h.walk();
        System.out.println(h.color); // Animal constructor is called because it is parent. Ans. brown
        h.changeColor(); // now, change color value for horse
        System.out.println(h.color); // white

        Chicken c = new Chicken(); // call Animal consstructor first then Chicken constructor is called.
        c.eat();
        c.walk();

        // Animal a = new Animal();
        // it gives error because Animal class is Abstrack we can't create object of abstract class.
    }
}

abstract class Animal {
    String color;
    Animal() { // Abstract constructor possible.
        color = "brown";// by default color is brown of animal
        System.out.println("Animal constructor called.......");
    }

    void eat() { // non-abstract method.
        System.out.println("Animal's eats...");
    }

    abstract void walk(); // we can't implement this abstract walk()
    // sub class compulsory implement this walk() method.
}

class Horse extends Animal {
    Horse() {
        System.out.println("Horse constructor called.......");
    }
    void changeColor() { // Change Animal color
        color = "white";
    }
    void walk() { // if we not implement walk() then code get error.
        System.out.println("Walk on 4 legs.");
    }
}

class Chicken extends Animal {
    Chicken() {
        System.out.println("Chicken constructor called.......");
    }
    void changeColor() {
        color = "brown white color";
    }
    void walk() {
        System.out.println("Walk on 2 legs.");
    }
}