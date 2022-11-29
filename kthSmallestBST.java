import java.util.*;
// Approach 1- Recursive 
class Solution { // TC O(n) SC O(n)
    List<Integer> list= new ArrayList<>();
    
    public void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public int kthSmallestBST(Node root, int k) {
        inorder(root);
        return list.get(k-1);
    }
}

// Approach 2- Iterative 
// The idea is to again build inorder traversal but with iterative we 
// can stop when k==0 and stop building the tree further 
class Solution1{ // TC O(H+k) SC O(H)
    public int kthSmallestBST(Node root, int k) {
        Stack<Node> stack= new Stack<>();
        while(true){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(--k==0) return root.val;
            root=root.right;
        }
    }
}

class kthSmallestBST{
	public static void main(String[] args) {
		BST2 bst2= new BST2();
		int[] keys={5,3,6,2,4,1};
		Node root=bst2.constructBST(keys);
		int k=3;
		Solution s= new Solution();
		System.out.println(s.kthSmallestBST(root,k));
		Solution1 s1= new Solution1();
		System.out.println(s1.kthSmallestBST(root,k));
	}
}