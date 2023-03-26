import java.util.*;
// Approach 1- DFS (Recursive) [using implicit call-stack]
class Solution{ // TC O(n) SC O(n)
  public int minDepth(Node root) {
    if (root == null) {
      return 0;
    }

    if ((root.left == null) && (root.right == null)) {
      return 1;
    }

    int min_depth = Integer.MAX_VALUE;
    if (root.left != null) {
      min_depth = Math.min(minDepth(root.left), min_depth);
    }
    if (root.right != null) {
      min_depth = Math.min(minDepth(root.right), min_depth);
    }

    return min_depth + 1;
  }
}

// Approach 2- BFS [using queue]
class Solution1{ // TC O(n) SC O(n)
    public int minDepth(Node root) {
        if(root==null) return 0;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        int depth=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            depth++;
            for(int i=0; i<size; i++){
                Node currNode= queue.poll();
                if (currNode.left==null && currNode.right==null){
                    return depth;
                }
                if (currNode.left!=null) queue.offer(currNode.left);
                if (currNode.right!=null) queue.offer(currNode.right);
            }
        }
        return depth;
    }
}

class minDepth{
  public static void main(String[] args) {
    BinaryTree bt=new BinaryTree();
    bt.root=new Node(1);
    bt.root.left=new Node(2);
    bt.root.right=new Node(3);
    bt.root.right.right=new Node(4);
    Solution s=new Solution();
    System.out.println(s.minDepth(bt.root));
  }
}
