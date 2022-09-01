/*
 * Deep copy
 */

public class E_DeepConstructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Amy";
        s1.roll = 456;
        s1.password = "abcd";
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;
        System.out.println("======s1 object======");
        s1.display(s1);
        
        Student s2 = new Student(s1); // copy s1 value to s2
        s2.password = "xyz";
        System.out.println("======s2 object======");
        s2.display(s2);
        
        // changing s1.marks[2] = 75
        s1.marks[2] = 75; // only s1 mark change. s2 marks not change.
        System.out.println("s1.marks[2] = "+s1.marks[2]+" & s2.marks[2] = "+s2.marks[2]);
        
        // changing s2.marks[2] = 95
        s2.marks[2] = 95; // only s2 mark change. s1 marks not change.
        System.out.println("s1.marks[2] = "+s1.marks[2]+" & s2.marks[2] = "+s2.marks[2]);
    }
}


class Student {
    String name;
    int roll;
    String password;
    int marks[] = new int[3];

    Student() {
        System.out.println("This is simple constructor.");
    }
    
    // (deep copy) copy constructor.
    Student(Student s1) {  // copy s1 object value & store in another object.
        this.name = s1.name;
        this.roll = s1.roll;
        for (int i = 0; i < 3; i++) {
            this.marks[i] = s1.marks[i]; // create new array and copy s1 values.
        }
    }
    
    
    public void display(Student s1) {
        System.out.println("=============================================");
        System.out.println("Name: "+s1.name);
        System.out.println("Roll no: "+s1.roll);
        System.out.println("Password: "+s1.password);
        for (int i = 0; i < 3; i++) {
            System.out.print(s1.marks[i]+" ");
        }
        System.out.println();
    }
}