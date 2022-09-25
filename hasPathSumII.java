import java.util.*;
// Approach 1- DFS (Recursive) [using call-stack]
// Also a backtracking algorithm
class Solution { // TC O(N^2) SC O(N)
    private void recurseTree(Node node, int remainingSum, List<Integer> pathNodes, List<List<Integer>> pathsList) {
        
        if (node == null) {
            return;
        }
        
        // Add the current node to the path's list
        pathNodes.add(node.val);
        
        // Check if the current node is a leaf and also, if it
        // equals our remaining sum. If it does, we add the path to
        // our list of paths
        if (remainingSum == node.val && node.left == null && node.right == null) {
            pathsList.add(new ArrayList<>(pathNodes));
        } else {
            
            // Else, we will recurse on the left and the right children
            this.recurseTree(node.left, remainingSum - node.val, pathNodes, pathsList);
            this.recurseTree(node.right, remainingSum - node.val, pathNodes, pathsList);
        }
        
        // We need to pop the node once we are done processing ALL of it's
        // subtrees.
        pathNodes.remove(pathNodes.size() - 1);
    }
    
    public List<List<Integer>> hasPathSumII(Node root, int sum) {
        List<List<Integer>> pathsList = new ArrayList<List<Integer>>();
        List<Integer> pathNodes = new ArrayList<Integer>();
        this.recurseTree(root, sum, pathNodes, pathsList);
        return pathsList;        
    }
}

class hasPathSumII{
    public static void main(String[] args) {
        BinaryTree bt= new BinaryTree();
        bt.root=new Node(5);
        bt.root.left=new Node(4);
        bt.root.right=new Node(8);
        bt.root.left.left=new Node(11);
        bt.root.left.left.left=new Node(7);
        bt.root.left.left.right=new Node(2);
        bt.root.right.left=new Node(13);
        bt.root.right.right=new Node(4);
        bt.root.right.right.left=new Node(5);
        bt.root.right.right.right=new Node(1);
        int sum=22;
        Solution s= new Solution();
        System.out.println(s.hasPathSumII(bt.root,sum));
    }
}