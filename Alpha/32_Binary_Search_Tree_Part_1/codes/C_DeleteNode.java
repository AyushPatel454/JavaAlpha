/*
 * ===> Question: 3: Delete A Node.
 * 
 * Step:
 * i) Find inorder Successor.
 *          Next sorted element of delete node.
 *          Example: Delete Node whose value is 5.
 *          Inorder of BST: 1, 3, 4, 5, 6, 8, 10
 *          ---> Inorder Succesor = 6
 *          ===> Inorder Succesort = Left most node in Right subTree (Because which is minimum in righ SubTree.)
 * ii) Replace Delete node value to Inorder Succesor.
 * iii) Delete Inorder Succesor.
 */

public class C_DeleteNode {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    // ---> Delete Node.
    public static Node delete(Node root, int val) {
        if(root.data < val) { // Root < val ---> Value present in Right SubTree.
            // Right sub tree.
            root.right = delete(root.right, val);
        }
        else if(root.data > val) {
            // Left sub tree.
            root.left = delete(root.left, val);
        }
        else { // Value == Root value.
            // Case: 1 - Leaf node
            if(root.left == null && root.right == null) {
                return null;
            }

            // Case: 2 - Single child
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }

            // Case: 3 - both childeren.
            Node IS = findInorderSuccessor(root.right); // Find Inorder Succesor.
            root.data = IS.data; // Replace IS with Root (Delete node.)
            root.right = delete(root.right, IS.data); // Delete Inorder Succesor from Right subTree.
        }

        return root;
    }

    // ---> Inorder successor.
    public static Node findInorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }

        // Print Inorder Successor
        System.out.println("Inorder Successor = "+root.data);
        
        return root; // Left most node in right subTree.
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

        int deleteNode = 5;
        System.out.println("Delete Node = "+deleteNode);
        delete(root, deleteNode); // Delete Node whose value = deleteNode... ... .. 

        inorder(root);
        System.out.println();
    }
}
