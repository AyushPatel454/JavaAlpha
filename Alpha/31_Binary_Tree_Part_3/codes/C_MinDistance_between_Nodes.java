/*
 * ===> Question: 4: Minimum Distance between 2 nodes.
 * You given a Tree & 2 nodes call n1 & n2. And you need to find out minimum Distance betwen two nodes.
 * 
 * --> Solve using LCA (Low common Ancestor) question approach.
 */

 import java.util.*;

 public class C_MinDistance_between_Nodes {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null; 
            this.right = null;
        }
    }
    
    // ---> Minimum Distance between 2 nodes.
    public static int minDist(Node root, int n1, int n2) {
        // 1st Find LCA (Least Common Ancestor) between n1 and n2.
        Node lca = lca2(root, n1, n2);
        // find distance LCA to n1
        int dist1 = lcaDist(lca,n1);
        // find distance LCA to n2
        int dist2 = lcaDist(lca,n2);

        // return total distance.
        return dist1 + dist2;
    }

    // ---> lcaDist ---> (finding distance between n(node) to LCA)
    public static int lcaDist(Node root, int n) {
        if(root == null) {
            return -1;
        }

        if(root.data == n) {
            return 0;
        }

        int leftDistance = lcaDist(root.left, n); // find left Subtree distance
        int rightDistance = lcaDist(root.right, n); // find right Subtree distance

        if(leftDistance == -1 && rightDistance == -1) { // if both are -1 = null means no path goes to n1 and n2 node.
            return -1;
        } else if(leftDistance == -1) { // only right subTree hase n1 or n2.
            return rightDistance + 1;
        } else { // only left subTree hase n1 or n2.
            return leftDistance + 1;
        }
    }

    // ---> Lowest Common Ancestor (LCA).
    public static Node lca2(Node root, int n1, int n2) { // O(n)
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLCA = lca2(root.left, n1, n2);
        Node rightLCA = lca2(root.right, n1, n2);

        if(rightLCA == null) {
            return leftLCA;
        }

        if(leftLCA == null) {
            return rightLCA;
        }

        return root; // rightLCA != NULL & leftLCA != NULL ---> Which means current node is our (LCA)Lowest Common Ancestor.
    }
    
    public static void main(String[] args) {
        /*         Tree
         *          1           
         *         / \
         *        2   3         n1 = 4 & n2 = 5 ---> LCA = 2
         *      / \  / \
         *     4  5 6   7       n1 = 4 & n2 = 7 ---> LCA = 1
         */

         Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);
         root.left.left = new Node(4);
         root.left.right = new Node(5);
         root.right.left = new Node(6);
         root.right.right = new Node(7);

         System.out.println("n1 = "+4+", n2 = "+6+", Minimum Distance = "+minDist(root, 4, 6)); //4
         System.out.println("n1 = "+4+", n2 = "+3+", Minimum Distance = "+minDist(root, 4, 3)); //3
         System.out.println("n1 = "+6+", n2 = "+7+", Minimum Distance = "+minDist(root, 6, 7)); //2
    }
}
