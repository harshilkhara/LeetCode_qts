import java.util.*;
// Approach 1- DFS (Recursion) [using implicit call-stack]
class Solution { // TC O(n) SC O(n)
  int post_idx;
  int[] postorder;
  int[] inorder;
  HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

  public Node helper(int in_left, int in_right) {
    // if there is no elements to construct subtrees
    if (in_left > in_right)
      return null;

    // pick up post_idx element as a root
    int root_val = postorder[post_idx];
    Node root = new Node(root_val);

    // root splits inorder list
    // into left and right subtrees
    int index = idx_map.get(root_val);

    // recursion 
    post_idx--;
    // build right subtree
    root.right = helper(index + 1, in_right);
    // build left subtree
    root.left = helper(in_left, index - 1);
    return root;
  }

  public Node buildTree(int[] inorder, int[] postorder) {
    this.postorder = postorder;
    this.inorder = inorder;
    // start from the last postorder element
    post_idx = postorder.length - 1;

    // build a hashmap value -> its index
    int idx = 0;
    for (Integer val : inorder)
      idx_map.put(val, idx++);
    return helper(0, inorder.length - 1);
  }
}

class buildTree{
  public static void main(String[] args) {
    int[] inorder={9,3,15,20,7};
    int[] postorder={9,15,7,20,3};
    Solution s= new Solution();
    BinaryTree bt=new BinaryTree();
    Node result=s.buildTree(inorder, postorder);
    bt.preorder(result);
  }
}