import java.util.*;
class Node{
  int val;
  Node left;
  Node right;

  Node(int x) {
    val = x;
  }
}

class BST2{

	//Node root; 

	public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void preorder(Node root)
    {	
        if (root == null) {
            return;
        }
 		System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(Node root)
    {	
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    // Recursive Approach TC O(log n) SC O(log n)
    public static Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }
 
        // if the given key is less than the root node,
        // recur for the left subtree
        if (key < root.val) {
            root.left = insert(root.left, key);
        }
 
        // otherwise, recur for the right subtree
        else {
            // key >= root.val
            root.right = insert(root.right, key);
        }
 
        return root;
    }

    // Iterative Approach TC O(log n) SC O(1)
    public Node insert2(Node root, int val) {
    Node node = root;
    while (node != null) {
      // insert into the right subtree
      if (val > node.val) {
        // insert right now
        if (node.right == null) {
          node.right = new Node(val);
          return root;
        }
        else node = node.right;
      }
      // insert into the left subtree
      else {
        // insert right now
        if (node.left == null) {
          node.left = new Node(val);
          return root;
        }
        else node = node.left;
      }
    }
    return new Node(val);
  }

    public static Node constructBST(int[] keys)
    {
        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }
        return root;
    }

    // Recursive Approach TC O(log n) SC O(log n)
    public static Node searchBST(Node root, int val){
    	 //System.out.println("lol");
    	 if (root == null || val == root.val) return root;
    	 return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    // Iterative Approach TC O(log n) SC O(1)
    public static Node searchBST2(Node root, int val){
    	while (root!=null && val!=root.val){
    		root= val < root.val ? root.left : root.right;
    	}
    	return root;
    }


}
class implementBST2{
	public static void main(String [] args){
    BST2 bst2= new BST2();
    int val= 5;
    int [] keys= {2,1,4,val};

    Node root=bst2.constructBST(keys); 
    System.out.println("Inorder -");
    bst2.inorder(root);
    System.out.println("");
    System.out.println("Preorder -");
    bst2.preorder(root);
    System.out.println("");
    System.out.println("Postorder -");
    bst2.preorder(root);
	System.out.println("");
	System.out.println("Search root - ");
    Node search=bst2.searchBST(root,7);
    bst2.preorder(search);


	}
}