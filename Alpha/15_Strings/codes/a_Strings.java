import java.util.Scanner;

public class a_Strings {
    public static void main(String[] args) {
        char arr[] = {'a','b','c','d'};

        // Both 2 mehtod are same.
        String str = "abcd";
        String str2 = new String("XYZ");

        // strings are IMMUTABLE

        // INPUT ----> Single word---> next()
        // INPUT ----> Multi word---> nextLine()
        Scanner sc = new Scanner(System.in);
        String name;
        name = sc.nextLine(); // take  multi word
        System.out.println("Name:"+name);

        // Lngth in sting.
        String FullName = "Tony Stark";
        System.out.println("Length of FullName: "+FullName.length());

        // concatenation
        String fName = "Amy";
        String lName = "Sadhu";
        String name2 = fName + lName; // concatenation
        System.out.println(name2);
        System.out.println(fName + " " + lName); // concatenation

        // .charAt(i) ---> where i is index.
        String school = "PHOENIX";
        System.out.println("At index no 1: "+school.charAt(1)); //P
        for (int i = 0; i < school.length(); i++) {
            System.out.print(school.charAt(i)+" ");
        }
        System.out.println();
    }
}