import java.util.*;
// Approach 1- Postorder DFS (Recursive) [using implicit call-stack]
// The trick is to maintain the global variable 
class Solution{
	int sum;
	public int postorder(Node root){
		if(root==null){
			return 0;
		}
		int left=Math.max(postorder(root.left),0);
		int right= Math.max(postorder(root.right),0);
		sum= Math.max(sum, left+right+root.val); 
		return Math.max(left+root.val, right+root.val);
	}

	public int maxPathSumBT(Node root){
		this.sum=Integer.MIN_VALUE;
		postorder(root);
		return sum;
	}
}


// Approach 1- Postorder DFS (Recursive) [using implicit call-stack]
// They both are exactly same
class Solution1{
    public int maxPathSumBT(Node root) {
        maxSum = Integer.MIN_VALUE;
        gainFromSubtree(root);
        return maxSum;
    }

    private int maxSum;

    // post order traversal of subtree rooted at `root`
    private int gainFromSubtree(Node root) {
        if (root == null) {
            return 0;
        }

        // add the path sum from left subtree. Note that if the path
        // sum is negative, we can ignore it, or count it as 0.
        // This is the reason we use `Math.max` here.
        int gainFromLeft = Math.max(gainFromSubtree(root.left), 0);

        // add the path sum from right subtree. 0 if negative
        int gainFromRight = Math.max(gainFromSubtree(root.right), 0);

        // if left or right path sum are negative, they are counted
        // as 0, so this statement takes care of all four scenarios
        maxSum = Math.max(maxSum, gainFromLeft + gainFromRight + root.val);

        // return the max sum for a path starting at the root of subtree
        return Math.max(gainFromLeft + root.val, gainFromRight + root.val);
    }
}

class maxPathSumBT{
	public static void main(String[] args) {
		BinaryTree bt= new BinaryTree();
		bt.root= new Node(1);
		bt.root.left= new Node(2);
		bt.root.right= new Node(3);
		Solution s= new Solution();
		System.out.println(s.maxPathSumBT(bt.root));
	}
}