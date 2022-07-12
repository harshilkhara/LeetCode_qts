import java.util.*;
class Node{
	int val;
	Node left; 
	Node right; 

	public Node(int x){
		val=x;
		//left=right=null;
	}
}
class BinaryTree{
	Node root; 
	/*
	BinaryTree(int key){ 
		root = new Node(key); 
	}
 
    BinaryTree(){ 
    	root = null; 
    }
    */

	// Recursive Approach TC O(N) SC O(N) or O(log n)
	public static int maxDepth(Node root){
		if (root==null) return 0; 
		return (1+Math.max(maxDepth(root.left),maxDepth(root.right)));
	}

	// Iterative Approach TC O(N) SC O(N) or O(log n)
	public static int maxDepth1(Node root) {
    LinkedList<Node> stack = new LinkedList<>();
    LinkedList<Integer> depths = new LinkedList<>();
    if (root == null) return 0;

    stack.add(root);
    depths.add(1);

    int depth = 0, current_depth = 0;
    while(!stack.isEmpty()) {
      root = stack.pollLast();
      current_depth = depths.pollLast();
      if (root != null) {
        depth = Math.max(depth, current_depth);
        stack.add(root.left);
        stack.add(root.right);
        depths.add(current_depth + 1);
        depths.add(current_depth + 1);
      }
    }
    return depth;
  }

  public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}

class maxDepth{
	public static void main(String[] args) {
		
		BinaryTree bt= new BinaryTree();
		bt.root=new Node(3);
		bt.root.left=new Node(9);
		bt.root.right=new Node(20);
		//bt.root.left.left=new Node(null);
		//bt.root.left.right=new Node(null);
		bt.root.right.left=new Node(15);
		bt.root.right.right=new Node(7);
		System.out.println("Inorder traversal - ");
		bt.inorder(bt.root);
		System.out.println("");
		System.out.println("Depth of the tree - ");
		System.out.println(bt.maxDepth1(bt.root));
		
	}
}