import java.util.*;
// Approach 1- Using BST's inorder traversal behavior 
class Solution{ // TC O(n) SC O(n)
	List<Integer> sortedList= new ArrayList<>();

	public void inorder(Node root){
		if (root==null) return; 
		inorder(root.left);
		sortedList.add(root.val);
		inorder(root.right);
	}

	public boolean twoSumBST(Node root,int target){
		inorder(root);
		int l=0, r=sortedList.size()-1;
		int sum=0;
		while(l<r){
			sum=sortedList.get(l)+sortedList.get(r);
			if (sum==target)
				return true;
			else if (sum<target)
				l++;
			else 
				r--;
		}
		return false;
	}
}

// Approach 2- Using HashSet & DFS (recursive) [using implicit call-stack]
class Solution1{ // TC O(n) SC O(n)
    public boolean twoSumBST(Node root, int k) {
        Set <Integer> set = new HashSet<>();
        return find(root, k, set);
    }
    public boolean find(Node root, int k, Set <Integer> set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}

// Approach 3- Using HashSet & BFS (iterative) [using queue]
class Solution2{ // TC O(n) SC O(n)
	public boolean twoSumBST (Node root, int k){
		Set<Integer> seen= new HashSet<>();
		Queue<Node> queue= new LinkedList<>();
		if (root==null) return false;
		queue.add(root);
		while(!queue.isEmpty()){
			Node currNode=queue.poll();
			if (seen.contains(k-currNode.val)) return true;
			seen.add(currNode.val);
			if (currNode.left!=null) queue.add(currNode.left);
			if( currNode.right!=null) queue.add(currNode.right);
		}
		return false; 
	}
}

class twoSumBST{
	public static void main(String[] args) {
		BST2 bst2= new BST2();
		int[] keys={5,3,6,2,4,7};
		Node root=bst2.constructBST(keys);
		int target=9;
		Solution s= new Solution();
		System.out.println(s.twoSumBST(root,target));
	}
}