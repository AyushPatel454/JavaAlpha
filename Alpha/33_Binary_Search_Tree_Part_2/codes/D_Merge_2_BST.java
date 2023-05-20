/*
 * ===> Question: 4: Merge 2 BSTs.
 * You given 2 BSTs you need to create single BST (Merge BST) which is 
 * Balanced BST.
 * 
 * Time complexity: O(n) or O(n+m) ---> linear time.
 * n = BST1 m = BST2
 * 
 * We know, sorted Array/ArrayList ------> Balanced BST.
 * 
 * Steps:
 * 1) Find BST1 inorder sequece. (arr1)
 * 2) Find BST2 inorder sequece. (arr2)
 * 3) Sorted arr1, sorted arr2 ---> Merge ---> Final sorted Array/ArrayList = arr1 + arr2
 * 4) Final Sorted Array/ArrayList ---> Balanced BST.
 */

import java.util.*;

public class D_Merge_2_BST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node mergeBSTs(Node root1, Node root2) {
        // step1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);
        
        // step2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        // step3 - Merge
        int i=0, j=0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i<arr1.size() && j<arr2.size()) {
            if(arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        
        while(i<arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }

        while(j<arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }

        // step4 - sortedAll ---> Balanced BST.
        Node root = createBST(finalArr, 0, finalArr.size()-1);
        
        return root;
    }

    public static void getInorder(Node root, ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }

        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    // ---> Create BST.
    public static Node createBST(ArrayList<Integer> arr, int st, int end) {
        if(st > end) {
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(arr.get(mid));

        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);

        return root;
    }

    // ---> Preorder
    public static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        /*
         *          2
         *         / \
         *        1   4
         *        BST1
         */
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);
        
        /*
         *          9
         *         / \
         *        3   12
         *        BST2
         */
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        /*
         *              3
         *            /   \
         *          1      9
         *           \    / \
         *            2  4  12
         *          Final ans = BST
         * (Merge BST = BST1 + BST2)
         *              
         */
        Node root = mergeBSTs(root1, root2);
        preorder(root);
    }
}
