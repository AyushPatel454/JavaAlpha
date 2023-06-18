/*
 * ===> Segment Tree.
 * Segment Tree is Full binary Tree.
 * Segment trees are special type of tree data structure which is used for solve Range Queries.
 * 
 * In segment tree Quries are maximum & Update operaion also maximum so reduce the time complexity of both operation that's why we use segment tree data structure.
 * 
 * Time Complexity:-
 * Queries = O(log n)
 * Update = O(log n)
 * ________________________________________________________________________________________
 * Counting & Meaning of Nodes.:-
 * Each node we store information/data (value) of specifie range.
 * 
 * Total number of levels = log n (base 2) Where, n = size of Array
 * Total number of nodes = 2n - 1 (Theritical.)
 * 
 * But, in code we take total number of nodes = 4*n (for safety purpose)
 * ________________________________________________________________________________________
 * arr[] = {1, 2, 3, 4, 5, 6, 7, 8}     n = 8
 * Segment Tree. (store range of i to j sum in node.)
 * 
 * data: ans of/sub array sum of different Ranges.
 *                                                                                                                                                       
 *                       36 (0, 7) (index from, index to)
 *                      /  \ 
 *                     /    \                                                         
 *                    /      \                                                         
 *                   /        \                                                       
 *                  /          \                                           
 *                 /            \                                                   
 *                /              \                                                  
 *       (0, 3)  10               26 (4,7)                                                 
 *             /   \            /    \                                               
 *            /     \          /      \                                              
 *   (0, 1)  3       7        11       15  (6,7)                                             
 *          / \     / \      /  \     /  \                                           
 *         /   \   /   \    /    \   /    \                                          
 *        1     2 3     4  5      6 7      8 
 *      (0,0)     (2,2)    (4,4)    (6,6)  (7,7)                            
 *            (1,1)   (3,3)     (5,5)
 * 
 * ________________________________________________________________________________________
 * See noted for better understanding...!!
 * ________________________________________________________________________________________
 * ---> Create Segment Tree:-
 * 
 * We not actually create Tree but we create an array with size = 4*n
 * We visulize array as tree.
 * 
 * Segment tree is full binary tree (BT). Also knows as proper tree.
 * Each node has 2 childeren excepte leaf nodes.
 * 
 * But we store information of segment tree node in array.
 *          Node
 *         /    \                
 *        /      \           
 *   left child   Right child                 
 * 
 * So, in array. Take Node index = i
 * left child index = (2*i) + 1
 * right child index = (2*i) + 2
 * ________________________________________________________________________________________
 * ---> Build Segment Tree:-
 * Time Complexity = O(n)
 * ________________________________________________________________________________________
 * ---> Query on Segment Tree:-
 * Time Complexity = O(log n)
 * ________________________________________________________________________________________
 * ---> Update in Array arr[] & Segment Tree tree[]
 * Time Complexity = O(log n)
 * ________________________________________________________________________________________
 */

public class A_Construct_SegmentTree_ST {
    static int tree[];

    // inilize segment tree.    Array Size = 4*n (Saftey purpose) Otherwise theroritical value of size = 2n - 1
    public static void init(int n) {
        tree = new int[4*n]; // size = 4*n (4*n ---> for safety purporse)
    }

    // ----> construct segment tree.
    // use divide and conquere approach.
    public static int buildST(int arr[], int i, int start, int end) { // O(n)
        // i = is my tree index.
        if(start == end) { // leaf node.
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = (start + end)/2;

        buildST(arr, (2*i)+1, start, mid);  // left subtree = (2 * i) + 1
        buildST(arr, (2*i)+2, mid+1, end);  // right subtree = (2 * i) + 2

        tree[i] = tree[(2*i) + 1] + tree[(2*i) + 2]; // root node value = left child + right child.

        return tree[i];
    }

    // ---> getSum (Query on Segment Tree.) // Range is given you need to find sum between range.
    public static int getSum(int arr[], int qi, int qj) { // O(log n)
        int n = arr.length;
        return getSumUtil(0, 0, n-1, qi, qj);
    }

    // ---> getSumUtil (Helper function of getSum)
    public static int getSumUtil(int i, int si, int sj, int qi, int qj) { // O(log n)
        // i = segment tree[] index.
        // si, sj ---> Node range.
        if(qj < si || qi > sj) { // non overlapping
            return 0;
        } else if(si >= qi && sj <= qj) { // coomplete overlap
            return tree[i];
        } else { // partial overlap
            int mid = (si + sj)/2;
            int left = getSumUtil(2*i + 1, si, mid, qi, qj); // left subtree
            int right = getSumUtil(2*i + 2, mid+1, sj, qi, qj); // right subtree

            return left + right;
        }
    }

    // ---> Update.
    public static void update(int arr[], int idx, int newVal) {
        int n = arr.length;
        int diff = newVal - arr[idx]; // diff
        arr[idx] = newVal; // Update in Array.

        updateUtil(0, 0, n-1, idx, diff);
        
        return;
    }

    // ---> Update in Segment Tree.
    // Time Complexity = O(logn)
    public static void updateUtil(int i, int si, int sj, int idx, int diff) { // segment tree updation.
        // i = index of tree[]

        if(idx > sj || idx < si) { // non overlapping.
            return;
        }

        // update node value
        tree[i] += diff;
        
        // if current node ---> non-leaf 
        if(si != sj) {
            int mid = (si + sj)/2;
            updateUtil(2*i + 1, si, mid, idx, diff); // update left node
            updateUtil(2*i + 2, mid+1, sj, idx, diff); // update right node
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;

        // inilize segment tree.
        init(n);

        // build segment tree.
        buildST(arr, 0, 0, n-1);

        // print segment tree array tree[] .
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
        System.out.println("(Visulize in Tree)Print in level order.");
        System.out.println();

        // ---> Get Sum
        System.out.println("Sum between index 2, 5 = "+getSum(arr, 2, 5)); // 18
        System.out.println("Sum between index 3, 4 = "+getSum(arr, 3, 4)); // 9
        System.out.println("Sum between index 3, 3 = "+getSum(arr, 3, 3)); // 9
        System.out.println("Sum between 0 to 7 index = "+getSum(arr, 0, n-1)); // 36

        // ---> Update
        System.out.println("\nUpdate Operation...!!");
        int idx = 2;
        int newVal = 2;
        // print array.
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Update idx = 2 value = 3");
        update(arr, idx, newVal);
        // print array.
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        // print segment tree array tree[] .
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        System.out.println("Sum between 0 to 7 index = "+getSum(arr, 0, n-1));
    }
}
