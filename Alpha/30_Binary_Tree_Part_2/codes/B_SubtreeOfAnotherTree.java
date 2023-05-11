/*
 * ===> Subtree of another Tree
 * Given the roots of 2 binary trees roots and sub root,
 * Return True if there is a subtree of root with same structure & node values of sub root and
 * False otherwise.
 * 
 * 1) Find SubRoot in Tree
 * 2) Check Identical
 * 
 * ---> Non-Identical conditions.
 * 1) node.data != subRoot.data
 * 2) node == null || subRoot == null (Any of 1 is null and other is not null)
 * 3) Left subTree is non-Identical
 * 4) Right subTree is non-Identical
 */

 public class B_SubtreeOfAnotherTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null; 
            this.right = null;
        }
    }

    // ---> isSubtree
    public static boolean isSubtree(Node root, Node subRoot) {
        if(root == null) {
            return false;
        }
        // finding Node which is match with subTree root node.
        if(root.data == subRoot.data) {
            if(isIdentical(root, subRoot)) {
                return true;
            }
        }

        // If left or right is Identical then return True.
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot); 
    }

    // ---> isIdentical
    public static boolean isIdentical(Node node, Node subRoot) {
        if(node == null && subRoot == null) {
            return true;
        } else if(node == null || subRoot == null || node.data != subRoot.data) {
            return false; // if node or subRoot is null (Only 1 is null) then is nod-Identical. OR node.data != subRoot.data
        }

        if(!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        /*         Tree
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

        /*    SubTree
         *      2
         *     / \
         *    4   5
         */

         Node subRoot = new Node(2);
         subRoot.left = new Node(4);
         subRoot.right = new Node(5);

         System.out.println(isSubtree(root, subRoot));
    }
}
