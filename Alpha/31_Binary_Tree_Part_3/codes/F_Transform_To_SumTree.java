/*
 * ===> Question: 6: Transform to sum tree.
 * Each node = sum of left subtree & right subtree.
 * 
 * Time Complexity: O(n)
 * 
 *      Tree
         1           
        / \
       2   3         
     / \  / \
    4  5 6   7

 Expected sum tree is:
         27           
        / \
       9   13         
     / \  / \
    0  0 0   0  
 */


 import java.util.*;

 public class F_Transform_To_SumTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null; 
            this.right = null;
        }
    }

    // ---> transform
    public static int transform(Node root) {
        if(root == null) {
            return 0;
        }

        int leftChild = transform(root.left); // take left node value (data).
        int rightChild = transform(root.right); // take right node value (data).

        int data = root.data; // stor current node value. & pass to parent node.

        int newLeft = root.left == null ? 0 : root.left.data; // if my root.left == null ---> then newLeft = 0. // If my root.left != null ---> then newLeft = root.left.data
        int newRight = root.right == null ? 0 : root.right.data; // if my root.right == null ---> then newRight = 0. // If my root.right != null ---> then newRight = root.right.data

        // current node value = new Left value + old left value + new right value + old right value.
        root.data = newLeft + leftChild + newRight+ rightChild;

        return data; // data.
    }

    // ---> Preorder
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
        /*         Tree
         *          1           
         *         / \
         *        2   3         
         *      / \  / \
         *     4  5 6   7       
         * 
         *  Expected sum tree is:
         * 
         *          27           
         *         / \
         *        9   13         
         *      / \  / \
         *     0  0 0   0       
         */

         Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);
         root.left.left = new Node(4);
         root.left.right = new Node(5);
         root.right.left = new Node(6);
         root.right.right = new Node(7);
         
         System.out.print("Before transform: ");
         preOrder(root);
         System.out.println();
         
         transform(root); // ---> Transform the tree in sum tree.
         
         System.out.print("After transform: ");
         preOrder(root);
         System.out.println();
    }
}
