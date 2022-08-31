/*
 * Constructor
 */

public class C_Constructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Ashmy");
        // System.out.println(s2.name);
        Student s3 = new Student(123);
        // System.out.println(s3.rolls);
    }
}

class Student {
    String name;
    int roll;

    Student() {
        System.out.println("Non-Parameter rise constructor is called.");
    }
    Student(String name) {
        this.name = name;
        System.out.println("Parameter rise Constructor is call.");
    }
    Student(int roll) {
        this.roll = roll;
        System.out.println("Parameter rise constructor but argument type is int.");
    }
}