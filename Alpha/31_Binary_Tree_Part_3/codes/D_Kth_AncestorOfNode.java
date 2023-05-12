/*
 * ===> Question: 5: Kth Ancestor of node.
 * Your given a node n & k. You need to find out kth Ancesstor of node.
 */

 import java.util.*;

 public class D_Kth_AncestorOfNode {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null; 
            this.right = null;
        }
    }

    // ---> Kth Ancestor.
    public static int KAncestor(Node root, int n, int k) {
        if(root == null) {
            return -1;
        }
        if(root.data == n) {
            return 0;
        }

        int leftDist = KAncestor(root.left, n, k); // find out distance of node n in left subtree
        int rightDist = KAncestor(root.right, n, k);// find out distance of node n in right subtree

        if(leftDist == -1 && rightDist == -1) { // means current's node left sub tree & righ sub tree our target node n is not present.
            return -1;
        }

        int max = Math.max(leftDist, rightDist); // may be our target node n is present in left or right sub tree.
        // If leftDist = -1 (Not present) rightDist = 0 or above
        // max = max(-1, 0) = 0 (Right sub tree distance is selected.)

        if(max+1 == k) { // if kth ancestor. (max + 1 = 0 + 1 = 1 current node is our 1st (kth) Ancestor)
            System.out.println(root.data);
        }

        return max+1; // for others kth.
    }
    
    public static void main(String[] args) {
        /*         Tree
         *          1           
         *         / \
         *        2   3         
         *      / \  / \
         *     4  5 6   7       
         */

         Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);
         root.left.left = new Node(4);
         root.left.right = new Node(5);
         root.right.left = new Node(6);
         root.right.right = new Node(7);

         int n = 5, k = 1;
         KAncestor(root, n, k);
    }
}
