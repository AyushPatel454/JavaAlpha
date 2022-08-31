public class P_SuperKeyword {
    public static void main(String[] args) {
        Horse h = new Horse();
        System.out.println(h.color);
    }
}

class Animal {
    String color;
    Animal() {
        System.out.println("Animal constructor is called.");
    }
}

class Horse extends Animal {
    Horse() {
        super(); // if we not written then java by default write super() 
        super.color = "brown";
        System.out.println("Horse constructor is called.");
    }
}