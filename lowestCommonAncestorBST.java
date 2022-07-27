// Approach 1- Recursive 
class Solution { // TC O(N) SC O(N)
    public Node lowestCommonAncestorBST(Node root, Node p, Node q) {

        // Value of current node or parent node.
        int parentVal = root.val;

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            // If both p and q are greater than parent
            return lowestCommonAncestorBST(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            // If both p and q are lesser than parent
            return lowestCommonAncestorBST(root.left, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }
}

// Approach 2- Iterative 
class Solution1{ // TC O(N) SC O(1)
    public Node lowestCommonAncestorBST(Node root, Node p, Node q){
        
        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        // Start from the root node of the tree
        Node node = root;

        // Traverse the tree
        while (node != null) {

            // Value of ancestor/parent node.
            int parentVal = node.val;

            if (pVal > parentVal && qVal > parentVal) {
                // If both p and q are greater than parent
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // If both p and q are lesser than parent
                node = node.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return node;
            }
        }
        return null;
    }
}

class lowestCommonAncestorBST{
    public static void main(String[] args) {
        int [] keys= {6,2,8,0,4,7,9,3,5};
        Node p = new Node (2);
        Node q= new Node(4);
        BST2 bst2 = new BST2();
        Node root= bst2.constructBST(keys); 
        bst2.inorder(root); 
        Solution s= new Solution();
        Node result= s.lowestCommonAncestorBST(root,p,q);
        bst2.inorder(result);
        Solution1 s1= new Solution1();
        Node result1= s1.lowestCommonAncestorBST(root,p,q);
        bst2.inorder(result1);
        


    }
}