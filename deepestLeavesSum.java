import java.util.*;
class Pair{
    Node node;
    int val;
    Pair(Node node, int val){
        this.node=node;
        this.val=val;
    }
}

// Approach 1- DFS (Iterative) [using explicit stack]
class Solution { // TC O(n) SC O(n)
    public int deepestLeavesSum(Node root) {
        if (root==null) return 0;
        Stack<Pair> stack=new Stack<>();
        stack.push(new Pair(root, 0));
        int depth=0, sum=0;
        while (!stack.isEmpty()){
            Pair p= stack.pop();
            Node currNode=p.node;
            int currDepth=p.val;
            if(currNode.left==null && currNode.right==null){
                if (currDepth>depth){
                    sum=currNode.val;
                    depth=currDepth;
                } else if (currDepth==depth){
                    sum+=currNode.val;
                }
            } else {
                if (currNode.right!=null) stack.push(new Pair(currNode.right, currDepth+1));
                if (currNode.left!=null) stack.push(new Pair(currNode.left, currDepth+1));
            } 
        }
        return sum;
    }
}

// Approach 2- DFS (Recursive) [using implicit call stack]
class Solution1{ // TC O(n) SC O(n)
    int answer=0;
    int currentDepth=0;

    public void dfs(Node root, int depth){
        if (root==null) return; 
        if (depth>currentDepth){
            currentDepth=depth;
            answer=root.val;
        } else if (currentDepth==depth){
            answer+=root.val;
        }
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
    
    public int deepestLeavesSum(Node root) {
        if (root==null)  return 0;
        dfs(root, 0);
        return answer;
    }
}

// Approach 3- Optimized BFS
class Solution2{ // TC O(n) SC O(n)
    public int deepestLeavesSum(Node root){
        ArrayDeque<Node> nextLevel=new ArrayDeque<>();
        ArrayDeque<Node> currLevel=new ArrayDeque<>();
        nextLevel.offer(root);
        while(!nextLevel.isEmpty()){
            currLevel=nextLevel.clone();
            nextLevel.clear();
            for(Node currNode: currLevel){
                if(currNode.left!=null) nextLevel.offer(currNode.left);
                if(currNode.right!=null) nextLevel.offer(currNode.right);
            }
        }
        int sum=0;
        for(Node node: currLevel){
            sum+=node.val;
        }
        return sum;
    }
} 


class deepestLeavesSum{
    public static void main(String[] args) {
        BinaryTree bt= new BinaryTree();
        bt.root=new Node(1);
        bt.root.left=new Node(2);
        bt.root.right=new Node(3);
        bt.root.left.left=new Node(4);
        bt.root.left.right=new Node(5);
        bt.root.right.right=new Node(6);
        bt.root.left.left.left=new Node(7);
        bt.root.right.right.right=new Node(8);
        Solution2 s2= new Solution2();
        System.out.println(s2.deepestLeavesSum(bt.root));
    }
}