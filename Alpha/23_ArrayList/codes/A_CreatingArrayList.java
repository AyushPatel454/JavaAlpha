/*
 * Array List
 * 
 * has dynamic size
 * primitive data types can't be stored directly (int can't store) (Integer store)
 * Types of Array List : Integer , Float , Boolean , String
 */

import java.util.ArrayList;

public class A_CreatingArrayList {
    public static void main(String[] args) {
        // Creating Integer type Array List
        ArrayList<Integer> list = new ArrayList<>(); 
        // Creating String type Array List
        ArrayList<String> list2 = new ArrayList<>(); 
        // Creating Boolean type Array List
        ArrayList<Boolean> list3 = new ArrayList<>();
        // Creating Float type Array List
        ArrayList<Float> list4 = new ArrayList<>();

        // ===> Operaion in Array List

        // .add() ---> Adding elements in Array List
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);

        // .get(a) ---> Get element at index no a
        System.out.println(list.get(0));
        System.out.println("Get element at index no 2 is: "+list.get(2)); // 3

        // .remove(a) ---> Remove element at index no a
        list.remove(3);
        System.out.println("Remove element at index no 3: List = "+list); // [1,2,3]

        // .set(a) ---> Set element at index no a
        list.set(2, 4);
        System.out.println("Set element at index no 2: List = "+list);

        // .contains(value) ---> Check value is in list or not. & return true if value is present otherwise return false
        boolean check = list.contains(3);
        System.out.println("3 is present in lis? : "+check);

        // .add(a,value) ---> Adding value after a-1 index.
        list.add(1,3);
        System.out.println("Adding 3 index 1: List = "+list);
    }
}