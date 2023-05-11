/*
 * ===> Diameter of Tree.
 * Diameter of Tree = Number of nodes in the longest path between 2 leaves.
 * 
 * ---> Approach 1
 * Time Complexity: O(n^2)
 * ---> Approach 2
 * Time Complexity: O(n)
 * 
 * Using BFS we will find out.
 */

 public class A_DiameterOfTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null; 
            this.right = null;
        }
    }

    // Height of Tree.
    public static int height(Node root) {
        if(root == null) { // If Tree is empty then height = 0
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    // Diameter of Tree 
    // ---> (Approach - 1) (Time complexity: O(n^2) ---> O( n * O(n) ) ---> O(n * Height complexity))
    public static int diameter(Node root) {
        if(root == null) {
            return 0;
        }

        int leftDiameter = diameter(root.left); // ---> Left diameter.
        int leftHeight = height(root.left);
        int rightDiameter = diameter(root.right); // ---> Right diameter.
        int rightHeight = height(root.right);

        int selfDiameter = leftHeight + rightHeight + 1; // Current node is part of diameter.
        
        return Math.max(selfDiameter, Math.max(rightDiameter, leftDiameter)); // Max (Left Diameter, Righ Diameter, Self) // ---> Maximum diameter is our answer.
    }
    
    // Diameter of Tree 
    // ---> (Approach - 2) Time complexity: O(n)
    /*
     * Create class Info.
     * In which store each node details of Diameter, height.
     * Which is help for parent to easily find out parent Node Diameter, height.
     */
    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }
    // Diameter2
    public static Info diameter2(Node root) {
        if(root == null) {
            return new Info(0,0); // null Node - Store DIAM = 0, HT = 0
        }
        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam,ht);
    }

    public static void main(String[] args) {
        /*
         *          1
         *         / \
         *        2   3
         *      / \  / \
         *     4  5 6   7
         */

         Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);
         root.left.left = new Node(4);
         root.left.right = new Node(5);
         root.right.left = new Node(6);
         root.right.right = new Node(7);

         System.out.println("(Approach: 1) Diameter = "+diameter(root));
         Info obj = diameter2(root);
         System.out.println("(Approach: 2) Diameter = "+ obj.diam +", Height = "+obj.ht);
    }
}
