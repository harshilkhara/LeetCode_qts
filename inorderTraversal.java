import java.util.*;

// Approach 1- DFS (Recursive) [using call-stack]
class Solution { // TC O(n) SC O(n)
    List<Integer> result= new ArrayList<>();
    public List<Integer> inorderTraversal(Node root) {
        inorder(root);
        return result;
    }
    
    public void inorder(Node root){
        if (root==null) return;
        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }
}

// Approach 2- DFS (Iterative) [using implicit stack]
class Solution1{ // TC O(n) SC O(n)
    public List<Integer> inorderTraversal(Node root){
        List<Integer> result=new ArrayList<>();
        Stack<Node> stack =new Stack<>();
        Node curr=root;
        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            result.add(curr.val);
            curr=curr.right;
        }
        return result;
    }
}

// Approach 3- Morris Traversal 
/*

1. Initialize current as root
2. While current is not NULL
If current does not have left child     
    a. Print current’s data
    b. Go to the right, i.e., current = current->right
Else
    a. In current's left subtree, make current the right child of the rightmost node
    b. Go to this left child, i.e., current = current->left

*/

class Solution2{ // TC O(n) SC O(1) 
    public List<Integer> inorderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        Node curr = root;
        Node pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                Node temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }
}

class inorderTraversal{
    public static void main(String[] args) {
        BinaryTree bt= new BinaryTree();
        bt.root=new Node(1);
        bt.root.right=new Node(2);
        bt.root.right.left=new Node(3);
        Solution s= new Solution();
        System.out.println(s.inorderTraversal(bt.root));
        Solution1 s1= new Solution1();
        System.out.println(s1.inorderTraversal(bt.root));
        Solution2 s2= new Solution2();
        System.out.println(s2.inorderTraversal(bt.root));
    }
}