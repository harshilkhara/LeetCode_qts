import java.util.*;
class Pair{
    Node node;
    int columnIndex;
    
    Pair(Node node, int columnIndex){
        this.node=node;
        this.columnIndex=columnIndex;
    }
}

// Approach 1- BFS 
class Solution { // TC O(n) SC O(1)
    public int widthOfBinaryTree(Node root) {
        if(root==null) return 0;
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(root, 0));
        int maxDepth=Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            Pair head=queue.peek();
            int size=queue.size();
            Pair p=null;
            for(int i=0; i<size; i++){
                p=queue.poll();
                Node currNode=p.node; 
                if(currNode.left!=null){
                    queue.add(new Pair(currNode.left, p.columnIndex*2));
                }
                if(currNode.right!=null){
                    queue.add(new Pair(currNode.right, p.columnIndex*2+1));
                }
            }
            maxDepth=Math.max(maxDepth, p.columnIndex-head.columnIndex+1);
        }
        return maxDepth;
    }
}

// Approach 2- DFS 
class Solution { // TC O(n) SC O(1)
    Map<Integer, Integer> map=new HashMap<>();
    int maxWidth=0;
    
    public void dfs(TreeNode root, int depth, int columnIndex){
        if(root==null) return; 
        
        if(!map.containsKey(depth)){
            map.put(depth, columnIndex);
        }
        int firstColIndex=map.get(depth);
        
        maxWidth=Math.max(maxWidth, columnIndex-firstColIndex+1);
        dfs(root.left, depth+1, columnIndex*2);
        dfs(root.right, depth+1, columnIndex*2+1);
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0);
        return maxWidth;
    }
}

class widthOfBinaryTree{
    public static void main(String[] args) {
        BinaryTree bt= new BinaryTree();
        bt.root=new Node(1);
        bt.root.left=new Node(2);
        bt.root.right=new Node(3);
        bt.root.left.left=new Node(5);
        bt.root.left.right=new Node(3);
        bt.root.right.right=new Node(9);
        Solution s=new Solution();
        System.out.println(s.widthOfBinaryTree(bt.root));
        Solution1 s1=new Solution1();
        System.out.println(s1.widthOfBinaryTree(bt.root));
    }
}