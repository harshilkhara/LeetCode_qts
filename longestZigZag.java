import java.util.*;
// Approach 1- DFS 
class Solution { // TC O(n) SC O(n)
    int pathLength = 0;
    private void dfs(TreeNode node, boolean goLeft, int steps) {
        if (node == null) {
            return;
        }
        pathLength = Math.max(pathLength, steps);
        if (goLeft) {
            dfs(node.left, false, steps + 1);
            dfs(node.right, true, 1);
        } else {
            dfs(node.left, false, 1);
            dfs(node.right, true, steps + 1);
        }
    }

    public int longestZigZag(TreeNode root) {
        dfs(root, false, 0);
        dfs(root, true, 0);
        return pathLength;
    }
}

class longestZigZag{
    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        bt.root=new Node();
        Solution s= new Solution();
    }
}