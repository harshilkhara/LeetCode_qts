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
// Approach 1- BFS [using queue]
class Solution{ // TC O(n) SC O(n)
	public List<Double> averageOfLevels(Node root){
		List<Double> ans= new ArrayList<>();
		if(root==null) return ans;
		Queue<Node> queue= new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size= queue.size();
			double sum=0;
			for(int i=0; i<size; i++){
				Node curr=queue.poll();
				sum+=curr.val;
				if(curr.left!=null) queue.add(curr.left);
				if(curr.right!=null) queue.add(curr.right);
			}
			ans.add(sum/size);
		}
		return ans;
	}
}

class averageOfLevels{
	public static void main(String[] args) {
		BinaryTree bt= new BinaryTree();
		bt.root=new Node(3);
		bt.root.left=new Node(9);
		bt.root.right= new Node(20);
		bt.root.right.left=new Node(15);
		bt.root.right.right=new Node(7);
		Solution s= new Solution();
		System.out.println(s.averageOfLevels(bt.root));
	}
}