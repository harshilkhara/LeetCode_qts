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

	public void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}

class Solution{  // TC O(N) SC O(N)
    public List<Integer> rightSideView(Node root) {
        if (root == null) return new ArrayList<Integer>();
        
        ArrayDeque<Node> nextLevel = new ArrayDeque() {{ offer(root); }};
        ArrayDeque<Node> currLevel = new ArrayDeque();        
        List<Integer> rightside = new ArrayList();
        
        Node node = null;
        while (!nextLevel.isEmpty()) {
            // prepare for the next level
            currLevel = nextLevel.clone();
            nextLevel.clear();

            while (! currLevel.isEmpty()) {
                node = currLevel.poll();

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) 
                    nextLevel.offer(node.left);    
                if (node.right != null) 
                    nextLevel.offer(node.right);
            }
            
            // The current level is finished.
            // Its last element is the rightmost one.
            if (currLevel.isEmpty()) 
                rightside.add(node.val);    
        }
        return rightside;
    }
}

class Solution1{ // TC O(N) SC O(N)
    public List<Integer> rightSideView(Node root) {
        List<Integer> rightSide= new ArrayList<>();
        List<Node> currLevel= new ArrayList<>();
        
        if (root!=null) currLevel.add(root);
        
        while(!currLevel.isEmpty()){
            List<Node> nextLevel= new ArrayList<>();
            
            rightSide.add(currLevel.get(currLevel.size()-1).val); 
            
            for (Node var: currLevel){
                if(var.left!=null){
                    nextLevel.add(var.left);
                }
                if(var.right!=null){
                    nextLevel.add(var.right);
                }
            }
            currLevel=nextLevel;
        }
        return rightSide;
        
    }
}

// Approach 3- Recursive DFS (Code similar to level order)

class Solution2{  // TC O(N) SC O(N)
	List<Integer> rightside = new ArrayList();
    
    public void helper(TreeNode node, int level) {
        if (level == rightside.size()) 
            rightside.add(node.val);
        
        if (node.right != null) 
            helper(node.right, level + 1);  
        if (node.left != null) 
            helper(node.left, level + 1);
    }    
    
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return rightside;
        
        helper(root, 0);
        return rightside;
    }
}

class rightSideView{
	public static void main(String[] args) {
		BinaryTree tree= new BinaryTree();
		Solution s= new Solution();
		Solution1 s1= new Solution1();

		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.left.right=new Node(5);
		tree.root.right=new Node(3);
		tree.root.right.right=new Node(4);
		tree.inorder(tree.root);

		System.out.println(s.rightSideView(tree.root));
		System.out.println(s1.rightSideView(tree.root));

		
	}
}