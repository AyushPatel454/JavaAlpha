/*
 * ===> Question: 2: Convert BST to Balanced BST.
 * Given you a Binary Search Tree (BST) you need to create Balanced Binary Search Tree (BST).
 * Means height of BST should be minimum.
 *  
 * Time complexity: O(n)
 */
import java.util.*;

 public class B_BST_To_BalancedBST {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    // ---> BST to Balanced BST
    public static Node balancedBST(Node root) {
        // inorder sequence.
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // sorted inorder ---> Balanced BST
        root = createBST(inorder, 0, inorder.size()-1);

        return root;
    }
    // ---> 1)st Find inorder
    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if(root == null) {
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    // ---> Create Balanced BST. (sorted ArrayList to Balanced BST)
    public static Node createBST(ArrayList<Integer> inorder, int st, int end) {
        if(st > end) {
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(inorder.get(mid));
        // 1St create Left sub tree.
        root.left = createBST(inorder, st, mid-1);
        // Create Right sub tree.
        root.right = createBST(inorder, mid+1, end);

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
        /*
         *            8
         *          /  \
         *         6   10      
         *        /     \
         *       5      11
         *      /        \
         *     3         12
         *  Given BST.
         */

        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        /*
         *           8
         *         /  \         Expected BST.
         *        5    11       Balanced BST.
         *       / \  / \
         *      3  6 10  12
         */

        root = balancedBST(root);
        preorder(root); // 8 5 3 6 11 10 12
    }
}
