/*
 * ===> Question: 2: Search a BST.
 * You need to find a key. Check key is present or not in Binary Search Tree.
 * If present then false TRUE. Otherwise print FALSE.
 * 
 * Time complexity: O(H) ---> Where, H = Hight of Tree.
 */

public class B_Search_a_Key_in_BST {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    // ---> Search element in Binary Search Tree (BST).
    public static boolean search(Node root, int key) {
        // Case: 1: Root = null ---> key is not presen in BST.
        if(root == null) {
            return false;
        }

        // Case: 2: Root = key ---> Return true.
        if(root.data == key) {
            return true;
        }

        // Case: 3: key < Root ---> Key may be present in left subtree.
        if(key < root.data) {
            return search(root.left, key);
        }

        // Case: 4: key > root ---> Key may be present in right subtree.
        // if(root.data < key) {
        else {
            return search(root.right, key);
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
        System.out.println();

        int key = 19;
        if(search(root, key)){
            System.out.println(key+" is found :)");
        } else{
            System.out.println(key+" is not found :(");
        }
    }
}
