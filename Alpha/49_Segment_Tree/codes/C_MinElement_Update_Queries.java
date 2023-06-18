/*
 * ===> Question: 2: Min Element Queries.
 * 
 * Given an arr[], we have to answer few queries:-
 * a) Output Min for the sub array [i...j] i to j.
 * b) Update the element at idx.
 * ________________________________________________________________________________________
 * Steps:-
 * 1) Build Min Segment Tree.
 * 2) Get min elemnt given ranges.
 * 3) Update element at given idx. & also update in segment tree.
 * ________________________________________________________________________________________
 * Time Complexity:-
 * Build Segment Tree = O(n)
 * Get Min Element = O(log n)
 * Update = O(log n)
 * ________________________________________________________________________________________
 */


public class C_MinElement_Update_Queries {
    static int[] tree;
    
    // inilize segment tree ---> tree[]
    public static void init(int n) {
        tree = new int[4*n];
    }

    // ---> Construct ===> Min Segment Tree.
    public static void buildMinST(int i, int si, int sj, int arr[]) { // O(n)
        if(si == sj) {
            tree[i] = arr[si];
            return;
        }

        int mid = si + (sj-si)/2; // optimse formula for large array.
        
        buildMinST(i*2 + 1, si, mid, arr);
        buildMinST(i*2 + 2, mid+1, sj, arr);

        tree[i] = Math.min(tree[2*i + 1], tree[2*i + 2]);

        return;
    }

    // ---> Query: Get Min Element in given ranges.
    public static int getMinElement(int arr[], int qi, int qj) { // O(log n)
        int n = arr.length;

        return get_MinElement_Util(0, 0, n-1, qi, qj); // find min in given ranges [qi, qj].
    }

    // ---> GetMin Util (Helper function)
    public static int get_MinElement_Util(int i, int si, int sj, int qi, int qj) { // O(log n)
        // No overlapp.
        if(si > qj ||  sj < qi) {
            return Integer.MAX_VALUE; // -ve Infinity
        } else if(qi <= si && sj <= qj) { // Complete overlap.
            return tree[i];
        } else { // Partial overlap.
            int mid = si + (sj - si)/2;
            int leftAns = get_MinElement_Util(2*i + 1, si, mid, qi, qj); // Min element in left sub tree.
            int rightAns = get_MinElement_Util(2*i + 2, mid+1, sj, qi, qj); // Min element in right sub tree.

            return Math.min(leftAns, rightAns);
        }

    }

    // ---> Query: update. Idx given & newValue given update.
    public static void update(int arr[], int idx, int newVal) {
        arr[idx] = newVal;
        int n = arr.length;
        
        updateUtil(0, 0, n-1, idx, newVal); // update in segment tree.
    }

    // ---> update in segment tree.
    public static void updateUtil(int i, int si, int sj, int idx, int newVal) {
        // no overlap
        if(idx < si || idx > sj) {
            return;
        }

        // overlapping case.
        // if leaf node then direct update with new Value.
        if(si == sj) {
            tree[i] = newVal;
        }
        
        // non-leaf
        if(si != sj) {
            tree[i] = Math.min(tree[i], newVal);
            int mid = (si+sj)/2;
            updateUtil(2*i +1, si, mid, idx, newVal); // left.
            updateUtil(2*i +2, mid+1, sj, idx, newVal); // right.
        }

    }

    public static void main(String[] args) {
        int arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        int n = arr.length;

        // inilize tree
        init(n);
        // construct segment tree
        buildMinST(0, 0, n-1, arr);

        // print max segment tree
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();


        // ---> Get Min Element
        int min = getMinElement(arr, 2, 5);
        System.out.println("Min elemnt between index 2 to 5 = "+min); // -1
        System.out.println("Min elemnt between index 8 to 8 = "+getMinElement(arr, n-1, n-1));

        // ---> Update
        update(arr, 2, 5);
        System.out.println("\nAfter update at idx = 2 & newValue = 5");
        min = getMinElement(arr, 2, 5);
        System.out.println("Min elemnt between index 2 to 5 = "+min); // -10
    }
}
