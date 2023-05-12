/*
 * ===> Question: Top View Of Tree.
 * 
 * ---> Level Order Traversing concept is use. & Hash map.
 * Solve using Hashmap. (In which we store unique HD as a key and it's value is Node (which Node HD))
 * Horizontal Distance of Node.
 * We need a class for storing information of Node & it's horizontal distance.
 */

import java.util.*;

 public class C_TopViewOfTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null; 
            this.right = null;
        }
    }

    // Storing information of Node & it's horizontal distance.
    static class Info {
        Node node;
        int horizontalDistance;

        public Info(Node node, int hd) {
            this.node = node;
            this.horizontalDistance = hd;
        }
    }

    // Top View
    public static void topView(Node root) {
        // Level Order
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0; // Min --> For left sub tree whose Horizontal distance are -ve (negative) & // Max --> For right sub tree whose horizontal distance are +ve (positive)
        q.add(new Info(root, 0)); // Root node & it's horizontal distace is alsways 0. (Because it's lies on origin)
        q.add(null);

        while(!q.isEmpty()) {
            Info curr = q.remove();
            if(curr == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                // First time hd is occuring.
                if(!map.containsKey(curr.horizontalDistance)) { // containsdKey ---> Check given key is already exist or not. // ---> If it's return TRUE that's means key is exist. If FALSE key is not exist
                    map.put(curr.horizontalDistance, curr.node); // key not exist. Then add in map usint ---> put
                }
                
                // Add current node's Left node if it's not null.
                // it's current left's that's why it's horizontal distance = currentNodeHorizontalDistance - 1
                if(curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.horizontalDistance - 1));
                    min = Math.min(min, curr.horizontalDistance - 1);
                }

                // Add current node's Right node if it's not null.
                // it's current Right's that's why it's horizontal distance = currentNodeHorizontalDistance + 1
                if(curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.horizontalDistance + 1));
                    max = Math.max(max, curr.horizontalDistance + 1);
                }
            }
        }
        // Printing nodes
        for(int i = min; i <= max; i++) {
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*         Tree
         *          1
         *         / \
         *        2   3         Answer: 4 2 1 3 7
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

         topView(root);
    }
}
