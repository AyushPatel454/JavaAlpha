/*
 * ===> Question: 6: Is Valid BST ?
 * Given you a Tree you need to determine it's valid Binary Search Tree (BST) or no.
 * It's satisfied when it's match all conditions of BST.
 * 
 */

 import java.util.*;

 public class F_IsValidBST {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    // ---> Is valid BST
    public static boolean isValidBST(Node root, Node min, Node max) {
        if(root == null) {
            return true;
        }

        if( min != null && root.data <= min.data) {
            return false;
        }
        else if(max != null && root.data >= max.data) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    // Insert node in BST. (Binary Search Tree)
    public static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val); // if Tree is empty then initialize root node with value(data)
            return root;
        }

        if(val < root.data) {
            // left subtree.
            root.left = insert(root.left, val); // return left subtree root node where values is exist.
        } else{
            // right subtree.
            root.right = insert(root.right, val); // return right subtree root node where value is exist.
        }
        

        return root; // return root node.
    }

    // Inorder Traverser. ---> For BST it's always in sorted order. To verify run this code.
    public static void inorder(Node root) {
        if(root == null) {
            return;
        }

        // Inoder sequece: left, root, right.
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

        return;
    }

    public static void main(String[] args) {
        int values[] = {8, 5, 10, 3, 6, 11, 14};
        // int values[] = {1,1,1};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        if(isValidBST(root, null, null)) {
            System.out.println("Valid !!");
        } else {
            System.out.println("Not Valid...!!");
        }
        System.out.println();
    }
}
