/*
 * ===> Question: 1: Build a Binary Search Tree. (BST)
 * 
 * value < root ---> Go in left subTree.
 * value > root ---> Go in right subTree.
 * 
 * if root = null then asign value. ---> root.data = value.
 */

public class A_BuildBST {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
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
        int values[] = {5, 9, 19, 25, 1, 3, 4, 2};
        Node root = null; // Tree root node. Initially it's empty.

        // add each element in Binary Search Tree. (BST)
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]); // Return root node of Build BST.
        }

        // Print Inoder ---> Validate it's print in sorted order.
        inorder(root);

        return;
    }
}
