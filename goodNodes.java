import java.util.*;
class Node{
    int val;
    Node left;
    Node right;

    Node(int x){
        val=x;
    }

}
class BinaryTree{
    Node root;
}

// Approach 1- DFS (Recursive)
class Solution { // TC O(n) SC O(n)
    private int numGoodNodes = 0;
    
    public int goodNodes(Node root) {
        dfs(root, Integer.MIN_VALUE);
        return numGoodNodes;
    }
    
    private void dfs(Node node, int maxSoFar) {
        if (maxSoFar <= node.val) {
            numGoodNodes++;
        }
        
        if (node.right != null) {
            dfs(node.right, Math.max(node.val, maxSoFar));
        }

        if (node.left != null) {
            dfs(node.left, Math.max(node.val, maxSoFar));
        }
    }
}

class Pair{
    Node node; 
    int maxSoFar; 

    Pair(Node root, int maxSoFar){
        node=root;
        this.maxSoFar=maxSoFar;
    }
}
// Approach 2- DFS (Iterative) [Using stack]
class Solution1{ // TC O(n) SC O(n)
    public int goodNodes(Node root){
        int numGoodNodes=0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root,Integer.MIN_VALUE));
        while(stack.size()>0){
            Pair curr= stack.pop();
            if (curr.maxSoFar<=curr.node.val){
                numGoodNodes++;

            }
            if (curr.node.left!=null){
                stack.push(new Pair(curr.node.left,Math.max(curr.node.val, curr.maxSoFar)));
            }
            if (curr.node.right!=null){
                stack.push(new Pair(curr.node.right,Math.max(curr.node.val, curr.maxSoFar)));
            }

        }
        return numGoodNodes;
    }

}

// Approach 3- BFS [using queue] 

class Solution2{ // TC O(n) SC O(n)
    public int goodNodes(Node root){
        int numGoodNodes=0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,Integer.MIN_VALUE));
        while(q.size()>0){
            Pair curr= q.poll();
            if (curr.maxSoFar<=curr.node.val){
                numGoodNodes++;
            }
            if(curr.node.left!=null){
                q.offer(new Pair(curr.node.left,Math.max(curr.node.val, curr.maxSoFar)));
            }
            if(curr.node.right!=null){
                q.offer(new Pair(curr.node.right,Math.max(curr.node.val, curr.maxSoFar)));
            }
        }
        return numGoodNodes;
    }
}

class goodNodes{
    public static void main(String[] args){
        BinaryTree bt= new BinaryTree();
        bt.root=new Node(3);
        bt.root.left=new Node(1);
        bt.root.left.left=new Node(3);
        bt.root.right=new Node(4);
        bt.root.right.left=new Node(1);
        bt.root.right.right=new Node(5);
        Solution s= new Solution();
        Solution1 s1= new Solution1();
        Solution2 s2= new Solution2();
        System.out.println(s.goodNodes(bt.root));
        System.out.println(s1.goodNodes(bt.root));
        System.out.println(s2.goodNodes(bt.root));
    }
}