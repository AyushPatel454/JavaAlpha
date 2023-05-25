/*
 * ===> Implementaion HashMap.
 * Manually implement all function of HashMap class.
 * 
 * put() ---> Time Complexity = O(1)
 * get() ---> Time Complexity = O(1)
 * containKey() ---> Time Complexity = O(1)
 * remove() ---> Time Complexity = O(1)
 * size() ---> Time Complexity = O(1)
 * 
 * ----------------------***See Notes For Understanding***----------------------
 */

import java.util.*;

public class C_Implementation_HashMap {
    static class HashMap<K, V> { // K,V --> Generic --> It's parameter type. // --> Means parameter can be int, float, boolean any thing.
        private class Node { // Create Node of Linked List.
            K key; // Key type ---> K --> Which is initially given & it can be anything.
            V value; // Value type ---> V

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // n ---> Total number of nodes in My HashMap which is exist.
        private int N; // Number of buckets.
        private LinkedList<Node> buckets[]; // N = buckets.length ---> Total buckets. --> It's Array it's store linked list.
        
        // @SuppressWarnings("unchecked") // If code get error then uncomment this line. In some version need to write this line. ---> E faltu warning ne nai ava de.
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4]; // Initially Bucket size = 4
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        // ---> Put() ---> // Time complexity = O(lambda) --> O(1) {Lambda is constent}
        public void put(K key, V value) { // O(1)
            // Find out ---> Bucked inde;
            int bi = hashFunction(key); // Bucket Index. // Initially 0 to 3

            // Search in Lined list. // & Return Data index.
            int di = SearchInLL(key, bi); // Find Data Index in Lined List.
            // 2 Cases --> i) Already exist , valid ii) Data is not exist , -1

            if(di != -1) { // Data key is exist.
                // Update only value.
                Node node = buckets[bi].get(di);
                node.value = value;
            } else { // Data key is not exist.
                // Create new node.
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = n/N;
            if(lambda > 2.0) { // lambda > Threshold value (Maximum value)
                rehash();
            }
        }

        // ---> Return Backet index of given key.
        private int hashFunction(K key) {
            // Find Hash code.
            int hc = key.hashCode(); // Hashing key. // Return Hash code value. // Change form of data.
            // 1223, -1223 , anything... ... ...
            
            // Take absoulte value.
            return Math.abs(hc) % N; // code it can be anything & we return answer from 0 to size-1 that's why we take modulo for find remander.
        }

        // ---> Return distance index of find node in specific bucket.
        private int SearchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0; // Data index of given key in specific backet inde.

            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key) { // Key exist.
                    return di;
                }
                di++;
            }
            
            return -1; // Key not exist.
        }

        
        public void rehash() {
            // Store current data in another data structur.
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[N*2];
            
            N = 2*N;
            
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
            
            // One by one remove node from old bucket & Add in New Bucket.
            for (int i = 0; i < oldBuck.length; i++) {
                LinkedList<Node> ll = oldBuck[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove(); // Remove node.
                    // Put old node into new bucket.
                    put(node.key, node.value);
                }
            }
        }

        // ---> containKeys() 
        public boolean containsKeys(K key) { // O(1)
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);
            
            if(di != -1) { // valid ---> Exists.
                return true;
            } else { // Invalid ---> Not exists.
                return false;
            }
        }

        // ---> get()
        public V get(K key) { // O(1)
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if(di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        // remove()
        public V remove(K key) { // O(1)
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if(di != -1) {
                Node node = buckets[bi].remove(di);
                n--; // Decrease total size of node by 1.
                return node.value;
            } else {
                return null;
            }
        }

        // ---> keySet() // ---> Return the ArrayList which contain keys.
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for(Node node : ll) {
                    keys.add(node.key);
                }
            }

            return keys;
        }

        // isEmpty()
        public boolean isEmpty() {
            return n == 0;
        }
    }
 
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>(); // our own HashMap. Not predefined.
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 5);

        ArrayList<String> keys = hm.keySet();
        for(String key : keys) {
            System.out.println(key);
        }

        System.out.println("Get: India = "+hm.get("India"));
        System.out.println("Remove: India ="+hm.remove("India"));
        System.out.println("Get: India = "+hm.get("India"));
    }
}
