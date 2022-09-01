/*
 * Hierachial Inheritance
 */

public class H_HierachialInheritance {
    public static void main(String[] args) {
        // Mammal object
        System.out.println("______________Mammal.......____________");
        Mammal mam = new Mammal();
        mam.eat();     // Animal class method access.  
        mam.breathe(); // Animal class method access.   
        mam.walk();
        
        // Fish object
        System.out.println("______________Fish.......______________");
        Fish shark = new Fish();
        shark.eat();     // Animal class method access.  
        shark.breathe(); // Animal class method access.   
        shark.swim();
        
        //Bird object
        System.out.println("______________Bird.......______________");
        Bird dove = new Bird();
        dove.eat();     // Animal class method access.  
        dove.breathe(); // Animal class method access.   
        dove.fly();
    }
}

// base class
class Animal {
    String color;

    void eat() {
        System.out.println("Eats");
    }
    void breathe() {
        System.out.println("Breathes");
    }
}

// derived class
class Mammal extends Animal{
    void walk() {
        System.out.println("Mammal are walk...");
    }
}

// derived class
class Bird extends Animal {
    void fly() {
        System.out.println("Birds are Fly....");
    }
}

// derived class
class Fish extends Animal {
    void swim() {
        System.out.println("Fish's are swim....");
    }
}