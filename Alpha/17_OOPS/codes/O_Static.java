/*
 * Static keyword
 * properties , function , block , nested-classes
 */

public class O_Static {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.schoolName = "Phoenix";
        // s1.percantage(90, 80, 50);
        System.out.println("s1 School Name: "+s1.schoolName); // Phoenix
        Student s2 = new Student();
        System.out.println("s2 School Name: "+s2.schoolName); // Phoenix

        Student s3 = new Student();
        // assign new value
        s3.schoolName = "Ambe";
        System.out.println("s3 School Name: "+s3.schoolName); // Ambe
        System.out.println("s1 School Name: "+s1.schoolName); // Ambe
        System.out.println("s2 School Name: "+s2.schoolName); // Ambe
    }
}

class Student {
    String name;
    int roll;

    static String schoolName;
    static int percantage(int a,int b,int c) {
        return (a+b+c)/3;
    }

    void setName(String name) {
        this.name = name;
    }
    String getName() {
        return this.name;
    }
}