/*
 * Array List ----> .size()
 * .size() ---> Return size of Array List 
 * 
 * Question: Print all elements of Arry List
 */

import java.util.ArrayList;

public class B_SizeArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        
        // adding elements in list
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // .size() --->  return size of array list. (like as array length ---> arr.length )
        System.out.println("Size of ArrayList of list = "+list.size());

        // print all elements of list
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
