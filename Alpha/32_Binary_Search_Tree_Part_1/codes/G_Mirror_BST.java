/*
 * ===> Question: 7: Mirror a BST.
 * 
 * Time Complexity: O(n)
 * 
                          BST Tree
                             8           
                            / \
                           5   10     Preorder: 8 5 3 6 10 11    
                         / \    \
                        3   6   11

                     Mirror of BST Tree:
                             8           
                            / \
                          10   5        Preorder: 8 10 11 5 6 3
                         /    / \
                        11   6   3

 */


 import java.util.*;

 public class G_Mirror_BST {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null; 
            this.right = null;
        }
    }

    // ---> Create Mirror iamge of BST.
    public static Node createMirror(Node root) { // Time complexity: O(n)
        if(root == null) {
            return null;
        }

        // Find left subtree mirror
        Node leaftMirror = createMirror(root.left);
        // Find right subtree mirror
        Node rightMirror = createMirror(root.right);

        // Swap left & right mirror image.
        root.left = rightMirror;
        root.right = leaftMirror;
        return root;
    }

    // Preorder
    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data +" ");
        preOrder(root.left);
        preOrder(root.right);

        return;
    }
    
    public static void main(String[] args) {
        /*         
                 8           
                / \
               5   10         
             / \    \
            3   6   11

        Mirror of BST Tree:
                 8           
                / \
              10   5        
             /    / \
            11   6   3     

         */

         Node root = new Node(8);
         root.left = new Node(5);
         root.right = new Node(10);
         root.left.left = new Node(3);
         root.left.right = new Node(6);
         root.right.right = new Node(11);
         
         System.out.print("Before Mirror image Preorder: ");
         preOrder(root);
         System.out.println();

         createMirror(root); // ---> Transform the tree in sum tree.
         
         System.out.print("After Mirror image Preorder: ");
         preOrder(root);
         System.out.println();
    }
}