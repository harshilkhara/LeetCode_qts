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

	public void preorder(Node root){
        if(root==null) return;
        System.out.print(root.val+ " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(Node root){
        if(root==null) return;
        
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val+ " ");
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