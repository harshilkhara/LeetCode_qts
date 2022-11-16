import java.util.*;
// Approach 1- Inorder travel to get a sorted list, then calculating the min diff
// Similar to closestValueBST.java thinking 
class Solution{ // TC O(n) SC O(n)
	List<Integer> list= new ArrayList<>();
	public void inorder(Node root){
		if(root==null) return;
		inorder(root.left);
		this.list.add(root.val);
		inorder(root.right);
	}

	public int minDiffBST(Node root){
		inorder(root);
		int ans=Integer.MAX_VALUE;
		for(int i=1; i<list.size(); i++){
			ans=Math.min(ans,list.get(i)-list.get(i-1));
		}
		return ans;
	}
}

// Approach 2- Again inorder traversal but simultaneously calculating the diff keeping prev val
class Solution1{ // TC O(n) SC O(n)
	Integer ans,prev;
	public void inorder(Node root){
		if (root==null) return;
		inorder(root.left);
		if(prev!=null){
			ans=Math.min(ans,root.val-prev);
		}
		prev=root.val;
		inorder(root.right);
	}

	public int minDiffBST(Node root){
		prev=null;
		ans=Integer.MAX_VALUE;
		inorder(root);
		return ans;
	}
}

class minDiffBST{
	public static void main(String[] args) {
		BST2 bst2= new BST2();
		int[] keys={4,2,6,1,3};
		Node root=bst2.constructBST(keys);
		Solution s= new Solution();
		System.out.println(s.minDiffBST(root));
		Solution1 s1= new Solution1();
		System.out.println(s1.minDiffBST(root));
	}
}