public class G_MultilevelInheritance {
    public static void main(String[] args) {
        Dog dobby = new Dog();
        dobby.eat(); // Animal class mehod can access.
        dobby.color = "brown"; // Animal class property can access.
        dobby.legs = 4; // Mammal class property can access.
        dobby.breed = "Pegigree";

        System.out.println("Color: "+dobby.color);
        System.out.println("Legs: "+dobby.legs);
        System.out.println("Breed: "+dobby.breed);
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
    int legs;
}

// derived class
class Dog extends Mammal {
    String breed;
}

