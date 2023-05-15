/*
 * ===> Question: 4: Print in Range.
 * 
 * Case: 1: k1 <= root <= k2 ---> Going in Left Sub Tree & Right Sub Tree.
 * Case: 2: root > k2 ---> Going in Left Sub Tree.
 * Case: 3: root < k1 ---> Going in Right Sub Tree.
 */

 public class D_Print_in_Range {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    // ---> Print in Range
    public static void printInRange(Node root, int k1, int k2) {
        if(root == null) {
            return;
        }

        if(root.data >= k1 && root.data <= k2) {
            // Print in Sorted wise (inOrder wise.)
            printInRange(root.left, k1, k2);    // Left
            System.out.println(root.data+" ");  // Root
            printInRange(root.right, k1, k2);   // Right
        }
        else if(root.data < k1) {
            printInRange(root.right, k1, k2);
        }
        else {
            printInRange(root.left, k1, k2);
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
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        printInRange(root, 1, 6);
        System.out.println();
    }
}
