// Approach 1- DFS [using call-stack]
class Solution { // TC O(N) SC O(N)
    public Node pruneTree(Node root) {
        return containsOne(root) ? root : null;
    }

    public boolean containsOne(Node node) {
        if (node == null) return false;
        
        // Check if any node in the left subtree contains a 1.
        boolean leftContainsOne = containsOne(node.left);
        
        // Check if any node in the right subtree contains a 1.
        boolean rightContainsOne = containsOne(node.right);

        // If the left subtree does not contain a 1, prune the subtree.
        if (!leftContainsOne) node.left = null;
        
        // If the right subtree does not contain a 1, prune the subtree.
        if (!rightContainsOne) node.right = null;
        
        // Return true if the current node, its left or right subtree contains a 1.
        return node.val == 1 || leftContainsOne || rightContainsOne;
    }

    public void inorder (Node root) {

        if(root==null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
        
    }
}

// Approach 2- DFS (simplified code) [using call-stack]
class Solution1{ // TC O(N) SC O(N)
    public Node pruneTree(Node root){
        if (root==null) return null; 

        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);

        if(root.val == 0 && root.left== null && root.right == null)
            root=null;

        return root;
    }
}

class pruneTree{
    public static void main(String[] args) {
        BinaryTree bt= new BinaryTree();
        bt.root=new Node(1);
        bt.root.right=new Node(0);
        bt.root.right.left=new Node(0);
        bt.root.right.right=new Node(1);
        Solution s =new Solution();
        Solution1 s1= new Solution1();
        Node x= s.pruneTree(bt.root);
        Node y= s1.pruneTree(bt.root);
        s.inorder(x);
        s.inorder(y);
    }
}