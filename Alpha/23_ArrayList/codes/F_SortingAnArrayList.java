/*
 * Sorting an ArrayList
 * 
 * ArrayList              |   Array
 * Collections.sort()     |   Arrays.sort()
 * 
 * 
 * Collections.sort() ---> sort in ascending order
 * import java.util.collectoins
 * 
 * Collections ---> Class
 * Collection  ---> Interface
 */

 import java.util.*;
// import java.util.Collections;
// import java.util.ArrayList;

public class F_SortingAnArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        System.out.println("Before Sorting the list = "+list);
        
        Collections.sort(list);
        
        System.out.println("After Sorting the list in ascendig list = "+list);

        Collections.sort(list,Collections.reverseOrder());
        // Comparator - fnx logic (sorting logic in reverse Order)

        System.out.println("After Sorting the list in descending list = "+list);
    }
}
