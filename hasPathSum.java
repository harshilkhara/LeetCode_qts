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

// Approach 1- DFS (Recursive) [using implicit call-stack]
class Solution{ // TC O(n) SC O(n)
	public boolean hasPathSum(Node root, int target){
		if (root==null) return false;
		target-=root.val;
		if (root.left==null & root.right==null){
			return (target==0);
		}
		return hasPathSum(root.left,target) || hasPathSum(root.right,target);
	}
}

// Approach 2- DFS (Iterative) [using explicit call-stack]
class Solution1{ // TC O(N) SC O(N)
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null)
      return false;

    LinkedList<TreeNode> node_stack = new LinkedList();
    LinkedList<Integer> sum_stack = new LinkedList();
    node_stack.add(root);
    sum_stack.add(sum - root.val);

    TreeNode node;
    int curr_sum;
    while ( !node_stack.isEmpty() ) {
      node = node_stack.pollLast();
      curr_sum = sum_stack.pollLast();
      if ((node.right == null) && (node.left == null) && (curr_sum == 0))
        return true;

      if (node.right != null) {
        node_stack.add(node.right);
        sum_stack.add(curr_sum - node.right.val);
      }
      if (node.left != null) {
        node_stack.add(node.left);
        sum_stack.add(curr_sum - node.left.val);
      }
    }
    return false;
  }
}

class hasPathSum{
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root=new Node(5);
		bt.root.left=new Node(4);
		bt.root.right=new Node(8);
		bt.root.left.left=new Node(11);
		bt.root.right.left=new Node(13);
		bt.root.right.right=new Node(4);
		bt.root.left.left.left=new Node(7);
		bt.root.left.left.right=new Node(2);
		bt.root.right.right.right=new Node(1);
		int target=22;
		Solution s= new Solution();
		System.out.println(s.hasPathSum(bt.root,target));
	}
}