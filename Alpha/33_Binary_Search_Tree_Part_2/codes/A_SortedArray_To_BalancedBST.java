/*
 * ===> Question: 1: Sorted Array to Balanced BST.
 * Given you a sorted array you need to create Balanced Binary Search Tree (BST).
 * Means height of BST should be minimum.
 * 
 * ---> IMP IMP IMP IMP IMP IMP IMP IMP (Used this concept in many problem as helper function.)
 * 
 * Time complexity: O(n)
 */

public class A_SortedArray_To_BalancedBST {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    // ---> Balanced BST
    public static Node createBST(int arr[], int st, int end) {
        if(st > end) {
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);
        // 1St create Left sub tree.
        root.left = createBST(arr, st, mid-1);
        // Create Right sub tree.
        root.right = createBST(arr, mid+1, end);

        return root;
    }

    // Preorder - Verify the BST.
    public static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        int arr[] = {3, 5, 6, 8, 10, 11, 12};
        /*
         *           8
         *         /  \
         *        5    11       Balanced BST.
         *       / \  / \
         *      3  6 10  12
         */

         Node root = createBST(arr, 0, arr.length-1);
         preorder(root);
    }
}
