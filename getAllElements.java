import java.util.*;
class TreeNode{
	TreeNode left;
	TreeNode right;
	int val; 
	TreeNode(int x){
		val=x;
	}
}

class BST3{
	public static TreeNode insertIntoBST(TreeNode root, int val){
		if (root==null) return new TreeNode(val);

		if (val<root.val) root.left=insertIntoBST(root.left,val);
		else root.right=insertIntoBST(root.right,val);

		return root; 
	}

	public static void preorder(TreeNode root){
		if(root==null) return; 
		System.out.print(root.val + " ");
		preorder(root.left);
		preorder(root.right);
	}

	public static TreeNode constructBST(int[] keys){
		TreeNode root= null;
		for (int key: keys){
			root=insertIntoBST(root,key);
		}
		return root;
	}

	// Recursive Approach  TC O(M+N log (M+N)) SC O(M+N)

	public static List<Integer> inorder(TreeNode root, List<Integer> arr) {
    if (root == null) return arr;
    inorder(root.left, arr);
    arr.add(root.val);
    inorder(root.right, arr);
    return arr;
  }

	public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> output = new ArrayList<>();
    //stream(inorder(root1, new ArrayList()), inorder(root2, new ArrayList())).forEach(o->output::addAll);
    output.addAll(inorder(root1,new ArrayList()));
    output.addAll(inorder(root2,new ArrayList()));
    Collections.sort(output);
    return output;
  }

  // Iterative Approach  TC O(M+N) SC O(M+N)

  public List<Integer> getAllElements1(TreeNode root1, TreeNode root2) {
    ArrayDeque<TreeNode> stack1 = new ArrayDeque(), stack2 = new ArrayDeque();
    List<Integer> output = new ArrayList();

    while (root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
      // update both stacks
      // by going left till possible
      while (root1 != null) {
        stack1.push(root1);
        root1 = root1.left;
      }
      while (root2 != null) {
        stack2.push(root2);
        root2 = root2.left;
      }

      // Add the smallest value into output,
      // pop it from the stack,
      // and then do one step right
      if (stack2.isEmpty() || !stack1.isEmpty() && stack1.getFirst().val <= stack2.getFirst().val) {
        root1 = stack1.pop();
        output.add(root1.val);
        root1 = root1.right;
      }
      else {
        root2 = stack2.pop();
        output.add(root2.val);
        root2 = root2.right;
      }
    }
    return output;
  }
}
	
class getAllElements{
	public static void main(String[] args){
		int [] keys1={2,1,4};
		int [] keys2={1,0,3}; 
		BST3 bst3 = new BST3();
		TreeNode root1=bst3.constructBST(keys1);
		TreeNode root2= bst3.constructBST(keys2); 
		System.out.println("Root 1- ");
		bst3.preorder(root1);
		System.out.println(" "); 
		System.out.println("Root 2- ");
		bst3.preorder(root2);
		List<Integer> result = new ArrayList<>();
		result= bst3.getAllElements(root1,root2);
		System.out.println(" "); 
		System.out.println("After getting all the elements (Recursion)-  "); 
		System.out.println(result.toString());
        List<Integer> result1 = new ArrayList<>();
		result1= bst3.getAllElements1(root1,root2);
		System.out.println(" "); 
		System.out.println("After getting all the elements(Iterative)-  "); 
		System.out.println(result1.toString());



	}
}