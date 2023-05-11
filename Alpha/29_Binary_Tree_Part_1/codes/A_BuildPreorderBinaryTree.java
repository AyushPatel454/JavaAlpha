/*
 * ===> Build Tree Preorder.
 * ===> Inorder
 * ===> Postorder
 * ===> Levelorder ---> (MIMP)
 * 
 * Build Binary Tree: Time complexity: O(n)
 * 
 * PreOrder traverse: Time Complexity: O(n) ---> Root, Left Tree, Right Tree
 * InOrder traverse: Time Complexity: O(n) ---> Left Tree, Root, Right Tree
 * PostOrder traverse: Time Complexity: O(n) ---> Left Tree, Right Tree, Root
 * 
 * LevelOrder traverse: Time Complexity: O(n) ---> Printing Level wise node.
 */
import java.util.*;

public class A_BuildPreorderBinaryTree {
    // Node Class ---> For create node of binary tree.
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // BinaryTree Class ---> For creating Binary Tree.
    static class BinaryTree{
        static int idx = -1; // every recursion my idx is updated that's why we take static.

        // Create Binary Tree.
        public static Node buildTree(int nodes[]) { // Time complexity: O(n)
            idx++;

            if(nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // ---> Traverse Binary Tree
        // Preorder. ---> Time complexity: O(n)
        // 1) Root, 2) Left Sub Tree, 3) Right Sub Tree
        public static void preOrder(Node root) {
            if(root == null) {
                return;
            }
            System.out.print(root.data+" "); // Printing Root node.
            preOrder(root.left); // Printing Left Sub tree.
            preOrder(root.right); // Printing Right Sub tree.
        }

        // Inorder. ---> Time complexity: O(n)
        // 1) Left Sub Tree, 2) Root, 3) Right Sub Tree
        public static void inOrder(Node root) {
            if(root == null) {
                return;
            }
            inOrder(root.left); // Printing Left Sub tree.
            System.out.print(root.data+" "); // Printing Root node.
            inOrder(root.right); // Printing Right Sub tree.
        }

        // Postorder. ---> Time complexity: O(n)
        // 1) Left Sub Tree, 2) Right Sub Tree, 3) Root
        public static void postOrder(Node root) {
            if(root == null) {
                return;
            }
            postOrder(root.left); // Printing Left Sub tree.
            postOrder(root.right); // Printing Right Sub tree.
            System.out.print(root.data+" "); // Printing Root node.
        }

        // Level Order. ---> Time Complexity: O(2n) = O(n)
        public static void levelOrder(Node root) {
            if(root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root); // initially add root & null in queue.
            q.add(null);

            while(!q.isEmpty()) {
                Node currNode = q.remove();

                if(currNode == null) {
                    System.out.println(); // print new line
                    if(q.isEmpty()) { // Queue is empty. Work done!!
                        break;
                    } else { // Queue is not empty then add NULL in last.
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data+" "); // print data
                    if(currNode.left != null) { // add left of currNode.
                        q.add(currNode.left);
                    }
                    if(currNode.right != null) { // add right of currNode.
                        q.add(currNode.right);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // Create Binary Tree
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        
        // Printing PreOrder.
        System.out.print("PreOrder: ");
        tree.preOrder(root);
        System.out.println();
        
        // Printing InOrder.
        System.out.print("InOrder: ");
        tree.inOrder(root);
        System.out.println();
        
        // Printing PostOrder.
        System.out.print("PostOrder: ");
        tree.postOrder(root);
        System.out.println();

        // Printing LevelOrder.
        System.out.println("Levelorder: ");
        tree.levelOrder(root);
    }
}
