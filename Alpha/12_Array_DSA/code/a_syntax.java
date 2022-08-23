// Basic syntax of array.

import java.util.Scanner;

public class a_syntax {
    public static void main(String[] args) {
        // Create Array with size 
        int arr[] = new int[50];
        int num[] = {1,2,3}; // size = 3
        String fruits[] = {"Apple","Mango","Orange"}; // size = 3

        //input
        int marks[] = new int[100];
        Scanner sc = new Scanner(System.in);
        marks[0] = sc.nextInt();
        marks[1] = sc.nextInt();
        marks[2] = sc.nextInt();

        System.out.println("Phy: "+marks[0]);
        System.out.println("Chem: "+marks[1]);
        System.out.println("Maths: "+marks[2]);

        // update value of array
        marks[2] = marks[2] + 1;
        System.out.println("Maths update: "+marks[2]);

        // array length ---> arr_name.length
        System.out.println("Array length: "+marks.length);
    }
}