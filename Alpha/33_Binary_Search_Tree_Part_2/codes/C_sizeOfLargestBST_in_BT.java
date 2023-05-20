/*
 * ===> Question: 3: Size of largest BST in BT.
 * Given you a Binary Tree (BT) you need to find out largest BINARY SEARCH TREE (BST) in Binary Tree (BT).
 *  
 * For understanding: See notes.
 * 
 * isValidBST ---> Function use (Which is used BST_PART1 ---> Question no: 6)
 * 
 * isValidBST
 *      if root == null ---> Return True.
 * 
 *      min ---> Minimum possible value.
 *      max ---> Maximum possible value.
 * 
 *      if (Root < MAX(left) || Root > MIN(right)) ---> Return False
 * 
 *      if(Root.data > left && Root.data < right) ---> Return True.
 * 
 *      else ---> Return False.
 * 
 * Get 4 information from each Sub Tree.
 * 1) Current node ---> isBST(bool)
 * 2) size ---> size of subTree
 * 3) min ---> Minimum value in subTree
 * 4) max ---> Maximum value in subTree. 
 */

public class C_sizeOfLargestBST_in_BT {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Information class---> Which take each node information.
    // like. IsBST ? , size of BST, min value in tree, max value in tree.
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    // Store max size of BST.
    // Update maxBST when current node isBST = true & it's left & right subTree is also isBST = true.
    public static int maxBST = 0;

    public static Info largestBST(Node root) {
        if(root == null) {
            // true , size = 0, min value = +VE infinity, max value = -VE infinity.
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // Take information from left subTree & right SubTree.
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        // isBST ?
        // if not then return ---> False
        if(root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }

        // is BST = True.
        // Then check my left SubTree & right Sub tree is BST?
        // IF right & left sub Tree are BST then ---> update max size of valid BST
        // & return true.
        if(leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min,max);
        }

        // if my left or right subTree is not BST. ---> Return FALSE.
        return new Info(false, size, min, max);
    }
    
    public static void main(String[] args) {
        /*
         *                      50
         *                    /   \
         *                  30     60
         *                 / \    /  \
         *                5  20  45  70
         *                          /  \
         *                         65  80
         *              
         *              Given Binary Tree (BT).
         */

        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        /*
         *                  60
         *                 /  \
         *                45  70
         *                   /  \
         *                  65  80
         * 
         *              Expected BST.
         *    Size = Total number of nodes = 5
         */

         Info info = largestBST(root);
         System.out.println("Largest BST size = "+maxBST);
    }
}
