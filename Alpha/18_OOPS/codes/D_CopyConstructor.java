/*
 * Constructor
 * 2 Types: Shallow Copy ---> (changes reflected in both objects) , Deep Copy ---> (Changes is not reflected)
 * Shallow Copy ---> copy through refrence. (Not new create arry)
 * Deep Copy ---> Create new array and assign old object array vlaue to new object.
 * 
 * Shallow Copy
 */

public class D_CopyConstructor {
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
        s1.display(s2);

        // changing s1.marks[2] = 75
        s1.marks[2] = 75; // s1 mark change and changes reflected in s2 marks also.
        System.out.println("s1.marks[2] = "+s1.marks[2]+" & s2.marks[2] = "+s2.marks[2]);
        
        // changing s2.marks[2] = 95
        s2.marks[2] = 95; // s2 mark change and changes reflected in s1 marks also.
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

    // (Shallow copy [changes reflected]) copy constructor.
    Student(Student s1) {  // copy s1 object value & store in another object.
        this.name = s1.name;
        this.roll = s1.roll;
        this.marks = s1.marks; // copy through refrence
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