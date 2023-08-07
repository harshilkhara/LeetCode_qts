import java.util.*;
class Node {
	int val;
	Node left;
	Node right;

	Node(){
		this.val=0;
	}

	Node(int val, Node left, Node right){
		this.val=val;
		this.left=left;
		this.right=right;
	}
}

// Approach 1- Top Down DP with Memoization
class Solution{

	Map<Integer, List<Node>> map=new HashMap<>();

	public List<Node> allPossibleFBT(int n){
		if(n%2==0) return new ArrayList<>();

		if(n==1) return Arrays.asList(new Node());

		if(map.containsKey(n)) return map.get(n);

		List<Node> res=new ArrayList<>();
		for(int i=1; i<n; i+=2){
			List<Node> left=allPossibleFBT(i);
			List<Node> right=allPossibleFBT(n-i-1);

			for(Node l: left){
				for(Node r: right){
					Node root=new Node(0, l, r);
					res.add(root);
				}
			}
		}
		map.put(n, res);
		return res;
	}
}

class allPossibleFBT{
	public static void main(String[] args) {
		BinaryTree bt= new BinaryTree();
		int n=7;
		Solution s=new Solution();
		List<Node> res= s.allPossibleFBT(n);

		for(Node root: res){
			bt.inorder(root);
		}
	}
}