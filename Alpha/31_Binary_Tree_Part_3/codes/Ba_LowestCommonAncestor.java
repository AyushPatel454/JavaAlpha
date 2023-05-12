/*
 * ===> Question: 2: Lowest Common Ancestor.
 * Giving Tree & 2 nodes called n1 & n2. You need to determine lowest common Ancestor (Parent) of 2 givien nodes.
 * 
 * Approach: 1) Time Complexity: O(n)
 * i) Find Path of Root to node. (Root--->n1 store in ArrayList path1) (Root--->n2 store in ArrayList path2)
 * ii) Find Last Common Node (LCA: Lowest Common Ancestor)
 *     Comparing path1 ArrayList to path2 ArrayList. & Find Common match node.
 */

 import java.util.*;

 public class Ba_LowestCommonAncestor {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null; 
            this.right = null;
        }
    }
    
    // ---> Lowest Common Ancestor. (Approach - 1)
    public static Node lca(Node root, int n1, int n2) { // O(n)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        // Step: 1 ---> Finding path.
        // Path from root to n1.
        getPath(root,n1,path1);
        // Path from root to n2.
        getPath(root,n2,path2);

        // Step: 2 ---> Finding common LCA.
        // Lowest Common Ancestor.
        int i = 0;
        for (; i < path1.size() && i <path2.size(); i++) {
            if(path1.get(i) != path2.get(i)) { // Now no LCA present.
                break;
            }
        }

        // last equal node = n - 1 (because in loop i increase by 1 at last.)
        Node lca = path1.get(i-1);
        return lca; // Return LCA node.
    }

    // getPath ---> Finding path from root to Node.
    public static boolean getPath(Node root,int n, ArrayList<Node> path) {
        if(root == null) { // means No path present.
            return false;
        }

        path.add(root); // add node in path.

        if(root.data == n) { // This is correct path because Target node is present in this path.
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path); // Find path in left sub tree. // Check target node is present or not in left sub tree.
        boolean foundRight = getPath(root.right, n, path); // Find path in right sub tree. // Check target node is present or not in right sub tree.

        if(foundLeft || foundRight) { // if any of the true means node is present. & Tell the answer to parent node. ---> Hey father you are right your son is present in your left sub tree or right sub tree :)
            return true;
        }

        // Target node not present. ---> Tell to father. ---> Father :( your son is not present in you left subTree and right subTree. Please you tell your father (grand father) also.
        path.remove(path.size()-1); // remove last(current) added node because in it's left sub tree & right sub Tree target node is not present. so we not need to add current node in path because is not correct way to go to target node.
        return false;
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

         System.out.println("n1 = "+4+", n2 = "+7+",LCA = "+lca(root, 4, 7).data); // 1
         System.out.println("n1 = "+4+", n2 = "+5+",LCA = "+lca(root, 4, 5).data); // 2
         System.out.println("n1 = "+4+", n2 = "+6+",LCA = "+lca(root, 4, 6).data); // 1
    }
}
