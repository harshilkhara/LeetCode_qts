import java.util.*;
// Approach 1- Iterative DFS (Preorder) [using explicit stack]
class Pair{ 
    Node root;
    int currNumber;
    Pair(Node root,int currNumber){
        this.root=root;
        this.currNumber=currNumber;
    }
}

class Solution{ // TC O(N) SC O(N)
    public int sumNumbers(Node root) {
        if (root==null) return 0;
        Stack<Pair> stack = new Stack<>();
        int sum=0, currNumber=0;
        stack.push(new Pair(root,0));
        while(!stack.isEmpty()){
            Pair p= stack.pop();
            Node currNode=p.root;
            currNumber=p.currNumber; 
            if(currNode!=null){
                currNumber=currNumber*10+currNode.val;
                if(currNode.left==null && currNode.right==null){
                    sum+=currNumber;
                } else {
                    stack.push(new Pair(currNode.left,currNumber));
                    stack.push(new Pair(currNode.right,currNumber));
                } 
            }
        }
        return sum;
    }
}
// Approach 2- Recursive (Preorder) [using call-stack]
class Solution1{ // TC O(N) SC O(N)
    int sum=0;
    public void preorder(Node root, int currNumber){
        if(root!=null){
            currNumber=currNumber*10+root.val;
            if(root.left==null && root.right==null){
                sum+=currNumber;
            }
            preorder(root.left,currNumber);
            preorder(root.right,currNumber);
        }
    }
    public int sumNumbers(Node root) {
        preorder(root,0);
        return sum;
    }
}

class rootToLeaf{
    public static void main(String[] args) {
        BinaryTree bt= new BinaryTree();
        bt.root= new Node(1);
        bt.root.left=new Node(2);
        bt.root.right=new Node(3);
        Solution s= new Solution();
        System.out.println(s.sumNumbers(bt.root));
        Solution1 s1= new Solution1();
        System.out.println(s1.sumNumbers(bt.root));
    }
}