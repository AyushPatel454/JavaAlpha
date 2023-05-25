/*
 * ===> Functions in Hash Map.
 */

import java.util.*;

public class A_HashMap_Functions {
    public static void main(String[] args) {
        // Create
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(hm); // {China=150, US=50, India=100}

        // Get - O(1)
        int population = hm.get("India"); // find value whose key is India.
        System.out.println(population); // 100

        System.out.println(hm.get("Indonesia")); // null ---> Indonesia is not valid key. Not store in Hashmap.

        // ContainsKey - O(1) ---> Key is exist or not in hash mpa ? Return boolean value.
        System.out.println(hm.containsKey("India")); // True
        System.out.println(hm.containsKey("Indonesia")); // False

        // Remove ---> Remove data whose key is Given. // Delete key & value.
        System.out.println(hm.remove("China")); // 150 & remove from hash map.
        System.out.println(hm); // {US=50, India=100}
        System.out.println(hm.remove("Nothing")); // null // Nothing is not valid key present in hash map.

        // Size
        System.out.println(hm.size()); // 2

        // Is Empty
        System.out.println(hm.isEmpty()); // false

        // clear --> Clear hash map.
        hm.clear();
        System.out.println(hm.isEmpty()); // true
    }
}
