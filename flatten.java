import java.util.*;
class Node{
    int val;
    Node left; 
    Node right; 

    public Node(int x){
        val=x;
        //left=right=null;
    }
}

class BinaryTree{
    Node root; 

    public void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}

// Approach 1- Recursion 
class Solution {
    
    private Node flattenTree(Node node) {
        
        // Handle the null scenario
        if (node == null) {
            return null;
        }
            
        // For a leaf node, we simply return the
        // node as is.
        if (node.left == null && node.right == null) {
            return node;
        }
        
        //Recursively flatten the left subtree
        Node leftTail = this.flattenTree(node.left);
        
        // Recursively flatten the right subtree
        Node rightTail = this.flattenTree(node.right);
        
        // If there was a left subtree, we shuffle the connections
        // around so that there is nothing on the left side
        // anymore.
        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
        // We need to return the "rightmost" node after we are
        // done wiring the new connections. 
        return rightTail == null ? leftTail : rightTail;
    }
    
    public void flatten(Node root) {
        
        this.flattenTree(root);
    }
}

// Approach 2- Iterative 
class Solution1{  // TC O(N) SC O(1)
   
    public void flatten(TreeNode root) {
        
        // Handle the null scenario
        if (root == null) {
            return;
        }
        
        TreeNode node = root;
        
        while (node != null) {
            
            // If the node has a left child
            if (node.left != null) {
                
                // Find the rightmost node
                TreeNode rightmost = node.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                
                // rewire the connections
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            
            // move on to the right side of the tree
            node = node.right;
        }
    }
}
class flatten{
    public static void main(String[] args) {
        BinaryTree tree= new BinaryTree();
        Solution s= new Solution();

        tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.right=new Node(5);
        tree.root.left.left=new Node(3);
        tree.root.left.right=new Node(4);
        tree.root.right.right=new Node(6);

        tree.inorder(tree.root);
        s.flatten(tree.root);
        tree.inorder(tree.root);
        
    }
}