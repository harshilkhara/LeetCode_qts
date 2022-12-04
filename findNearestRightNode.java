import java.util.*;
// Approach 1- BFS [using queue] (level order traversal)
class Solution{ // TC O(n) SC O(n)
	public Node findNearestRightNode(Node root, int u){
		if(root==null) return null;
		Queue<Node> queue= new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int levelSize=queue.size();
			for(int i=0; i<levelSize; i++){
				Node currNode= queue.poll();
				if(currNode.val==u){
					if(i==levelSize-1){
						return null;
					} else {
						return queue.poll();
					}
				}
				if(currNode.left!=null) queue.add(currNode.left);
				if(currNode.right!=null) queue.add(currNode.right);
			}
		}

		return null;
	}
}

class findNearestRightNode{
	public static void main(String[] args) {
		BinaryTree bt= new BinaryTree();
		bt.root=new Node(1);
		bt.root.left=new Node(2);
		bt.root.right= new Node(3);
		bt.root.left.right=new Node(4);
		bt.root.right.left=new Node(5);
		bt.root.right.right=new Node(6);

		Solution s= new Solution();
		int u=4;
		Node result=s.findNearestRightNode(bt.root, u);
		System.out.println(result.val);
		//bt.inorder(result);
		
	}
}