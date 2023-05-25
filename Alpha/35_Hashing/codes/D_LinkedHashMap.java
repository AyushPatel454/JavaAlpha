/*
 * ===> Linked Hash Map.
 * 
 * Linked Hash Map is simillar is HashMap.
 * Key difference: keys are insertion order. (With help of LinkedHashMap we can maintain the order of key insertion.) {je key pela add thay hase e key pela dekahse.}
 * 
 * Functions:
 * put()    get()       remove()    ---> All functions are same is HashMap function with same Time complexity: O(n)
 * size()   isEmpty()   keySet()    ---> All functions are same is HashMap function with same Time complexity: O(n)
 */

import java.util.*;

public class D_LinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("Nepal", 5);

        System.out.println("\tKey order is manatin in Linked Hash Map\nLinked Hash Map = "+lhm);


        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("Nepal", 5);

        System.out.println("\tKey order is ***NOT*** manatin in Hash Map\nHash Map = "+hm);
    }
}
