/*
 * ===> Question: 3: Lowest Common Ancestor.
 * Giving Tree & 2 nodes called n1 & n2. You need to determine lowest common Ancestor (Parent) of 2 givien nodes.
 * 
 * Approach: 2) Time Complexity: O(n) Space Complexity: O(n) Because, we use Recusion so n times memory locate for recusions.
 * LCA = 1st Ancestor whose subtree both n1 and n2 is preset.
 * 
 * If n1 is present in Left subtree and In right subtree also n2 is present thren current Root node is our LCA
 */

 import java.util.*;

 public class Bb_LowestCommonAncestor {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null; 
            this.right = null;
        }
    }
    
    // ---> Lowest Common Ancestor. (Approach - 2)
    public static Node lca2(Node root, int n1, int n2) { // O(n)
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLCA = lca2(root.left, n1, n2);
        Node rightLCA = lca2(root.right, n1, n2);

        if(rightLCA == null) {
            return leftLCA;
        }

        if(leftLCA == null) {
            return rightLCA;
        }

        return root; // rightLCA != NULL & leftLCA != NULL ---> Which means current node is our (LCA)Lowest Common Ancestor.
    }
    
    public static void main(String[] args) {
        /*         Tree
         *          1           
         *         / \
         *        2   3         n1 = 4 & n2 = 5 ---> LCA = 2
         *      / \  / \
         *     4  5 6   7       n1 = 4 & n2 = 7 ---> LCA = 1
         */

         Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);
         root.left.left = new Node(4);
         root.left.right = new Node(5);
         root.right.left = new Node(6);
         root.right.right = new Node(7);

         System.out.println("n1 = "+4+", n2 = "+7+",LCA = "+lca2(root, 4, 7).data); // 1
         System.out.println("n1 = "+4+", n2 = "+5+",LCA = "+lca2(root, 4, 5).data); // 2
         System.out.println("n1 = "+4+", n2 = "+6+",LCA = "+lca2(root, 4, 6).data); // 1
    }
}
