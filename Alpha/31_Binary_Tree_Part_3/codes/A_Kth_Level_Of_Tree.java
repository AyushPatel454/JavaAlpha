/*
 * ===> Question: 1: Kth level of Tree.
 * Print kth level all nodes value.
 * 
 * Time Complexity: O(n)
 */

 import java.util.*;

 public class A_Kth_Level_Of_Tree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null; 
            this.right = null;
        }
    }
    
    // Kth level node.
    public static void kThLevel(Node root, int level, int k) {
        if(root == null) {
            return;
        }

        if(level == k) { // if level == kth level
            System.out.print(root.data + " "); // print value of node.
            return; // No need to go k+1 level that's why we return.
        }

        kThLevel(root.left, level+1, k); // Going level+1 left sub Tree.
        kThLevel(root.right, level+1, k); // Going level+1 right sub Tree.

        return;
    }
    
    public static void main(String[] args) {
        /*         Tree
         *          1           Level-1
         *         / \
         *        2   3         Level-2
         *      / \  / \
         *     4  5 6   7       Level-3
         */

         Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);
         root.left.left = new Node(4);
         root.left.right = new Node(5);
         root.right.left = new Node(6);
         root.right.right = new Node(7);

         kThLevel(root, 1, 3); // 2, 3
    }
}
