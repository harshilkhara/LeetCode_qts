class Node{
	Node left;
	Node right;
	int val;

	public Node(int x){
		val=x;
	}
}

class BinaryTree{
	Node root;

	public void inorder(Node root){
		if(root==null) return;
		inorder(root.left);
		System.out.print(root.val+ " ");
		inorder(root.right);
	}
}

class implementBinaryTree{
	public static void main(String[] args) {
		BinaryTree bt= new BinaryTree();
		bt.root= new Node(1);
        bt.root.left=new Node(2);
        bt.root.right=new Node(3);
        bt.root.left.left=new Node(4);
        bt.root.left.right=new Node(5);
        bt.inorder(bt.root);
	}
}