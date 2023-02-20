import java.util.*;
// Approach 1- BFS 
class Solution{ // TC O(n) SC O(n)
	public List<List<Integer>> zigzagLevelOrder(Node root){
		List<List<Integer>> ans=new ArrayList<>();
		if(root==null) return ans;
		Queue<Node> queue=new LinkedList<>();
		queue.offer(root);
		int level=0;
		while(!queue.isEmpty()){
			int size=queue.size();
			List<Integer> list=new ArrayList<>();
			for(int i=0; i<size; i++){
				Node currNode=queue.poll();
				list.add(currNode.val);
				if(currNode.left!=null) queue.add(currNode.left);
				if(currNode.right!=null) queue.add(currNode.right);
			}
			if(level%2==1){
				Collections.reverse(list);
			}
			ans.add(new ArrayList<>(list));
			level++;
		}
		return ans;
	}
}

// Approach 2 - BFS 
class Solution1{ // TC O(n) SC O(n)
  public List<List<Integer>> zigzagLevelOrder(Node root) {
    if (root == null) {
      return new ArrayList<List<Integer>>();
    }

    List<List<Integer>> results = new ArrayList<List<Integer>>();

    // add the root element with a delimiter to kick off the BFS loop
    LinkedList<Node> node_queue = new LinkedList<Node>();
    node_queue.addLast(root);
    node_queue.addLast(null);

    LinkedList<Integer> level_list = new LinkedList<Integer>();
    boolean is_order_left = true;

    while (node_queue.size() > 0) {
      Node curr_node = node_queue.pollFirst();
      if (curr_node != null) {
        if (is_order_left)
          level_list.addLast(curr_node.val);
        else
          level_list.addFirst(curr_node.val);

        if (curr_node.left != null)
          node_queue.addLast(curr_node.left);
        if (curr_node.right != null)
          node_queue.addLast(curr_node.right);

      } else {
        // we finish the scan of one level
        results.add(level_list);
        level_list = new LinkedList<Integer>();
        // prepare for the next level
        if (node_queue.size() > 0)
          node_queue.addLast(null);
        is_order_left = !is_order_left;
      }
    }
    return results;
  }
}

// Approach 3- DFS 
class Solution1{ // TC O(n) SC O(n)
  protected void DFS(Node node, int level, List<List<Integer>> results) {
    if (level >= results.size()) {
      LinkedList<Integer> newLevel = new LinkedList<Integer>();
      newLevel.add(node.val);
      results.add(newLevel);
    } else {
      if (level % 2 == 0)
        results.get(level).add(node.val);
      else
        results.get(level).add(0, node.val);
    }

    if (node.left != null) DFS(node.left, level + 1, results);
    if (node.right != null) DFS(node.right, level + 1, results);
  }

  public List<List<Integer>> zigzagLevelOrder(Node root) {
    if (root == null) {
      return new ArrayList<List<Integer>>();
    }
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    DFS(root, 0, results);
    return results;
  }
}

class zigzagLevelOrder{
	public static void main(String[] args) {
		BinaryTree bt= new BinaryTree();
		bt.root=new Node(3);
		bt.root.left=new Node(9);
		bt.root.right=new Node(20);
		bt.root.right.left=new Node(15);
		bt.root.right.right=new Node(7);
		Solution s= new Solution();
		System.out.println(s.zigzagLevelOrder(bt.root));
	}
}