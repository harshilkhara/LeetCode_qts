import java.util.*;
// Approach 1- BFS [using queue]
class Solution { // TC O(n) SC O(n)
    public boolean isCompleteTree(Node root) {
        if (root == null) {
            return true;
        }

        boolean nullNodeFound = false;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node == null) {
                nullNodeFound = true;
            } else {
                if (nullNodeFound) {
                    return false;
                }
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return true;
    }
}

// Approach 2- DFS (Recursive) [using implicit call-stack]
class Solution1{ // TC O(n) SC O(n)
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public boolean dfs(TreeNode node, int index, int n) {
        if (node == null) {
            return true;
        }
        // If index assigned to current node is greater or equal to the number of nodes
        // in tree, then the given tree is not a complete binary tree.
        if (index >= n) {
            return false;
        }
        // Recursively move to left and right subtrees.
        return dfs(node.left, 2 * index + 1, n) &&
                dfs(node.right, 2 * index + 2, n);
    }

    public boolean isCompleteTree(TreeNode root) {
        return dfs(root, 0, countNodes(root));
    }
}
class isCompleteTree{
    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        bt.root=new Node(1);
        bt.root.left=new Node(2);
        bt.root.right=new Node(3);
        bt.root.left.left=new Node(4);
        bt.root.left.right=new Node(5);
        bt.root.right.left=new Node(6);
        Solution s=new Solution();
        System.out.println(s.isCompleteTree(bt.root));
    }
}