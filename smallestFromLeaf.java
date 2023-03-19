import java.util.*;
// Approach 1- DFS (Recursive) [using implict call-stack]
class Solution { // TC O(n) SC O(n)
    String ans="~";
    public String smallestFromLeaf(Node root) {
        dfs(root, new StringBuilder());
        return ans;
    }
    
    public void dfs(Node root, StringBuilder sb){
        if(root==null) return;
        sb.append((char) ('a'+root.val));
        if(root.left==null && root.right==null){
            sb.reverse();
            String s=sb.toString();
            sb.reverse();
            
            if(s.compareTo(ans)<0){
                ans=s;
            }
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length()-1);
    }
}

class smallestFromLeaf{
    public static void main(String[] args) {
        BinaryTree bt= new BinaryTree();
        bt.root=new Node(0);
        bt.root.left=new Node(1);
        bt.root.right=new Node(2);
        bt.root.left.left=new Node(3);
        bt.root.left.right=new Node(4);
        bt.root.right.left=new Node(3);
        bt.root.right.right=new Node(4);
        Solution s= new Solution();
        System.out.println(s.smallestFromLeaf(bt.root));

    }
}