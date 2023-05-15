/*
 * ===> Question: 5: Print Root to Leaf Path.
 * 
 * Case: 1: k1 <= root <= k2 ---> Going in Left Sub Tree & Right Sub Tree.
 * Case: 2: root > k2 ---> Going in Left Sub Tree.
 * Case: 3: root < k1 ---> Going in Right Sub Tree.
 */

import java.util.*;

 public class E_PrintRoot2LeafPath {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    // ---> Print Root to Leaf paths.
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }

        path.add(root.data); // Add node in path.

        if(root.left == null && root.right == null) {
            // current node is leaf node.
            // print path.
            printPath(path);
        }

        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        // At backTrack rmove last element of ArrayList.
        path.remove(path.size() - 1);
    }

    // print paths.
    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " -> ");
        }
        System.out.println("Null");
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
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        printRoot2Leaf(root, new ArrayList<>());
        System.out.println();
    }
}
