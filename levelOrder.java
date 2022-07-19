import java.util.*;

// Recursive Approach 
class Solution { // TC O(N) // SC O(N)
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(Node node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

         // fulfil the current level
         levels.get(level).add(node.val);

         // process child nodes for the next level
         if (node.left != null)
            helper(node.left, level + 1);
         if (node.right != null)
            helper(node.right, level + 1);
    }
    
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }
}

// Iterative Approach 
class Solution1{ // TC O(N) // SC O(N)
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    if (root == null) return levels;

    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    int level = 0;
    while ( !queue.isEmpty() ) {
      // start the current level
      levels.add(new ArrayList<Integer>());

      // number of elements in the current level
      int level_length = queue.size();
      for(int i = 0; i < level_length; ++i) {
        Node node = queue.remove();

        // fulfill the current level
        levels.get(level).add(node.val);

        // add child nodes of the current level
        // in the queue for the next level
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
      // go to next level
      level++;
    }
    return levels;
  }
}

class levelOrder{
    public static void main(String[] args) {
        BinaryTree bt= new BinaryTree(); 
        Solution s= new Solution();
        Solution1 s1= new Solution1();
        bt.root=new Node(3);
        bt.root.left=new Node(9);
        bt.root.right=new Node(20);
        bt.root.right.left=new Node(15);
        bt.root.right.right=new Node(7);
        bt.inorder(bt.root);
        List<List<Integer>> result= s.levelOrder(bt.root);
        System.out.println(result.toString());
        List<List<Integer>> result1= s1.levelOrder(bt.root);
        System.out.println(result1.toString());
    }
}