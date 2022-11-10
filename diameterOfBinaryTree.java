class Solution {
    private int diameter;
    public int diameterOfBinaryTree(Node root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }
    private int longestPath(Node node){
        if(node == null) return 0;
        // recursively find the longest path in
        // both left child and right child
        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        // update the diameter if left_path plus right_path is larger
        diameter = Math.max(diameter, leftPath + rightPath);

        // return the longest one between left_path and right_path;
        // remember to add 1 for the path connecting the node and its parent
        return Math.max(leftPath, rightPath) + 1;
    }
}

class diameterOfBinaryTree{
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Solution s= new Solution();
        bt.root= new Node(1);
        bt.root.left=new Node(2);
        bt.root.right=new Node(3);
        bt.root.left.left=new Node(4);
        bt.root.left.right=new Node(5);
        System.out.println(s.diameterOfBinaryTree(bt.root));
    }
}