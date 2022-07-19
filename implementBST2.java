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

    // Deleting a node 

    /*

    1) Successor = "after node", i.e. the next node, or the smallest node after the current one.
       It's also the next node in the inorder traversal. To find a successor, 
       go to the right once and then as many times to the left as you could.

    2) Predecessor = "before node", i.e. the previous node, or the largest node before the 
       current one. It's also the previous node in the inorder traversal. To find a predecessor, 
       go to the left once and then as many times to the right as you could.

	Algorithm- 

	If key > root.val then delete the node to delete is in the right subtree 
	root.right = deleteNode(root.right, key).

	If key < root.val then delete the node to delete is in the left subtree 
	root.left = deleteNode(root.left, key).

	If key == root.val then the node to delete is right here. Let's do it :

		If the node is a leaf, the delete process is straightforward : root = null.

		If the node is not a leaf and has the right child, then replace the node 
		value by a successor value root.val = successor.val, and then recursively 
		delete the successor in the right subtree root.right = deleteNode(root.right, root.val).

		If the node is not a leaf and has only the left child, then replace the node 
		value by a predecessor value root.val = predecessor.val, and then recursively 
		delete the predecessor in the left subtree root.left = deleteNode(root.left, root.val).

	Return root.

	*/


    /*
  One step right and then always left
  */
  public static int successor(Node root) {
    root = root.right;
    while (root.left != null) root = root.left;
    return root.val;
  }

  /*
  One step left and then always right
  */
  public static int predecessor(Node root) {
    root = root.left;
    while (root.right != null) root = root.right;
    return root.val;
  }

  public static Node deleteNode(Node root, int key) {
    if (root == null) return null;

    // delete from the right subtree
    if (key > root.val) root.right = deleteNode(root.right, key);
    // delete from the left subtree
    else if (key < root.val) root.left = deleteNode(root.left, key);
    // delete the current node
    else {
      // the node is a leaf
      if (root.left == null && root.right == null) root = null;
      // the node is not a leaf and has a right child
      else if (root.right != null) {
        root.val = successor(root);
        root.right = deleteNode(root.right, root.val);
      }
      // the node is not a leaf, has no right child, and has a left child    
      else {
        root.val = predecessor(root);
        root.left = deleteNode(root.left, root.val);
      }
    }
    return root;
  }


}
class implementBST2{
	public static void main(String [] args){
    BST2 bst2= new BST2();
    int val= 5;
    int [] keys= {2,1,4};

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
    Node search=bst2.searchBST(root,2);
    bst2.preorder(search);
	System.out.println("");
	System.out.println("After Deleting the given node - ");
    bst2.deleteNode(root,2);
    bst2.preorder(root);



	}
}