/*
 * ===> Question: 1: Max Element Queries.
 * 
 * Given an arr[], we have to answer few queries:-
 * a) Output Max for the sub array [i...j] i to j.
 * b) Update the element at idx.
 * ________________________________________________________________________________________
 * Steps:-
 * 1) Build Max Segment Tree.
 * 2) Get max elemnt given ranges.
 * 3) Update element at given idx. & also update in segment tree.
 * ________________________________________________________________________________________
 * Time Complexity:-
 * Build Segment Tree = O(n)
 * Get Max Element = O(log n)
 * Update = O(log n)
 * ________________________________________________________________________________________
 * See notes for better understanding...!!
 */


public class B_MaxElement_Update_Queries {
    static int[] tree;
    
    // inilize segment tree ---> tree[]
    public static void init(int n) {
        tree = new int[4*n];
    }

    // ---> Construct ===> Max Segment Tree.
    public static void buildMaxST(int i, int si, int sj, int arr[]) { // O(n)
        if(si == sj) {
            tree[i] = arr[si];
            return;
        }

        int mid = si + (sj-si)/2; // optimse formula for large array.
        
        buildMaxST(i*2 + 1, si, mid, arr);
        buildMaxST(i*2 + 2, mid+1, sj, arr);

        tree[i] = Math.max(tree[2*i + 1], tree[2*i + 2]);

        return;
    }

    // ---> Query: Get Max Element in given ranges.
    public static int getMaxElement(int arr[], int qi, int qj) { // O(log n)
        int n = arr.length;

        return get_MaxElement_Util(0, 0, n-1, qi, qj); // find max in given ranges [qi, qj].
    }

    // ---> GetMax Util (Helper function)
    public static int get_MaxElement_Util(int i, int si, int sj, int qi, int qj) { // O(log n)
        // No overlapp.
        if(si > qj ||  sj < qi) {
            return Integer.MIN_VALUE; // -ve Infinity
        } else if(qi <= si && sj <= qj) { // Complete overlap.
            return tree[i];
        } else { // Partial overlap.
            int mid = si + (sj - si)/2;
            int leftAns = get_MaxElement_Util(2*i + 1, si, mid, qi, qj); // Max element in left sub tree.
            int rightAns = get_MaxElement_Util(2*i + 2, mid+1, sj, qi, qj); // Max element in right sub tree.

            return Math.max(leftAns, rightAns);
        }

    }

    // ---> Query: update. Idx given & newValue given update.
    public static void update(int arr[], int idx, int newVal) {
        arr[idx] = newVal; // update in arr[] array.
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
        // if leaf node then direct update with new value.
        if(si == sj) {
            tree[i] = newVal;
        }
        
        // non-leaf
        if(si != sj) {
            tree[i] = Math.max(tree[i], newVal);
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
        buildMaxST(0, 0, n-1, arr);

        // print max segment tree
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();


        // ---> Get Max Element
        int max = getMaxElement(arr, 2, 5);
        System.out.println("Max elemnt between index 2 to 5 = "+max); // 17
        System.out.println("Max elemnt between index 8 to 8 = "+getMaxElement(arr, n-1, n-1));

        // ---> Update
        update(arr, 2, 22);
        System.out.println("\nAfter update at idx = 2 & newValue = 22");
        max = getMaxElement(arr, 2, 5);
        System.out.println("Max elemnt between index 2 to 5 = "+max); // 22
    }
}
