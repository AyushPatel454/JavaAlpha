/*
 * INHERITANCE...
 * extends ---> keyword is used to acces parnt class property in derived class
 * 
 * Single level Inheritance.
 */

public class F_Inheritance {
    public static void main(String[] args) {
        Fish shark = new Fish();
        shark.eat(); // Access Animal class mehod.
    }
}

// Base class
class Animal {
    String color;

    void eat() {
        System.out.println("Eats");
    }
    void breathe() {
        System.out.println("Breathes");
    }
}

// Derived class
class Fish extends Animal { // extend keyword is used to inheritance
    int fins;

    void swim() {
        System.out.println("Swims in water.");
    }
}