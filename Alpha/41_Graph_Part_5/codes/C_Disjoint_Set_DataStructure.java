/*
 * ===> Disjoint Set Data Structure.
 * 
 * - used to store & track non-overlpping sets.
 * - 2 Operations:
 *      i) Find(x):- Which set element belongs to.
 *     ii) Union(a, b):- Join 2 sets.(If both element belongs same set then create cycle.)
 * 
 * - Used in detect cycle in Graph.
 * - Used in Kruskal's algorithm.
 * 
 * ----------------> Time Complexity: O(1) <----------------
 * 
 * ------> See notes for better understanding.
 */

public class C_Disjoint_Set_DataStructure {
    static int n = 8;
    static int[] parent = new int[n];
    static int[] ranked = new int[n];

    public static void init() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i; // pote j pota no parent.
            ranked[i] = 0; // saruat ma darek no ranked 0.
        }
    }

    // Find leader of x (Spreme parent).
    public static int find(int x) { // Time Complexity = O(1)  Mathemateically ---> O(4k) k = constent.
        if(parent[x] == x) { // pote j pota no parent hoy to return kari daisu.
            return x;
        }

        // return find(parent[x]); // more calls go every time.

        // Path comparestion.
        // each node direct store it's leader.
        return parent[x] = find(parent[x]); // optimise. // update parent with leader. // so, time is reduce to call again and again.
    }

    public static void union(int a, int b) { // Time Complexity = O(1)
        int parA = find(a); // Find leader (supreme parent) of a.
        int parB = find(b); // Find leader (supreme parent) of b.

        if(ranked[parA] == ranked[parB]) { // banee na rank same hoy to. (Koi bi ek ne ek no parent banavi laisu).
            parent[parB] = parA; // parent B = A (B ne A sathe jodi daisu.)
            ranked[parA]++; // Ranked of A = ranked of A + 1
        } else if(ranked[parA] < ranked[parB]) {
            parent[parA] = parB; // parent of A = B (A ne B sathe jodi daisu.)
        } else { // ranked[parA] > ranked[parB]
            parent[parB] = parA; // parent of B = A (B ne A sathe jodi daisu..)
        }
    }

    public static void main(String[] args) {
        init();
        
        System.out.println(find(3)); // 3
        union(1, 3);
        System.out.println(find(3)); // 1
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3)); // 1
        System.out.println(find(4)); // 1
        union(1, 5);
    }
}
