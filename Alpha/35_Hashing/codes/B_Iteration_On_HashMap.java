/*
 * ===> Iteration on HashMap.
 */

import java.util.*;

public class B_Iteration_On_HashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);

        // Iterate
        // hm.entrySet();
        Set<String> keys = hm.keySet(); // collections of keys. Data type of key is String is given in hm.
        System.out.println("Keys = "+keys);

        for (String k : keys) { // Loop on keysets.
            System.out.println("Key = "+k+", value = "+hm.get(k));

        }
    }
}
