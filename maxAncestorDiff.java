import java.util.*;
// Approach 1- DFS (Preorder) Recursion 
class Solution { // TC O(n) SC O(n)
    public int dfs (Node root, int currMin, int currMax){
        if(root==null){
            return currMax-currMin;
        }
        currMin=Math.min(root.val,currMin);
        currMax=Math.max(root.val,currMax);
        int left= dfs(root.left, currMin, currMax);
        int right= dfs(root.right, currMin, currMax);
        return Math.max(left,right);
    }
    public int maxAncestorDiff(Node root) {
       if (root==null) return 0;
        return dfs(root,root.val,root.val);

    }
}

class maxAncestorDiff{
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root= new Node(8);
        bt.root.left=new Node (3);
        bt.root.right= new Node(10);
        bt.root.left.left= new Node(1);
        bt.root.left.right= new Node(6);
        bt.root.left.right.left=new Node(4);
        bt.root.left.right.left.right= new Node(7);
        bt.root.right.right=new Node(14);
        bt.root.right.right.left= new Node(13);
        Solution s= new Solution();
        System.out.println(s.maxAncestorDiff(bt.root));
    }
}