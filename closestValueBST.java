import java.util.*;
// Approach 1- Recursive inorder + linear search
class Solution { // TC O(n) SC O(n)
  public void inorder(Node root, List<Integer> nums) {
    if (root == null) return;
    inorder(root.left, nums);
    nums.add(root.val);
    inorder(root.right, nums);
  }

  public int closestValueBST(Node root, double target) {
    List<Integer> nums = new ArrayList<>();
    inorder(root, nums);
    return Collections.min(nums, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
      }
    });
  }
}

// Approach 2- Iterative inorder 
class Solution1{ // TC O(n) SC O(n)
  public int closestValueBST(Node root, double target) {
    LinkedList<Node> stack = new LinkedList();
    long pred = Long.MIN_VALUE;

    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.add(root);
        root = root.left;
      }
      root = stack.removeLast();

      if (pred <= target && target < root.val)
        return Math.abs(pred - target) < Math.abs(root.val - target) ? (int)pred : root.val;

      pred = root.val;
      root = root.right;
    }
    return (int)pred;
  }
}

// Approach 3- Binary Search 
class Solution2{ // TC O(H) SC O(1)
  public int closestValueBST(Node root, double target) {
    int val, closest = root.val;
    while (root != null) {
      val = root.val;
      closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
      root =  target < root.val ? root.left : root.right;
    }
    return closest;
  }
}

class closestValueBST{
  public static void main(String[] args) {
    BST2 bst2 = new BST2();
    int[] keys={1,2,3,4,5};
    double target= 6.7;
    Node root= bst2.constructBST(keys); 
    bst2.inorder(root);
    System.out.println("");
    Solution s= new Solution();
    System.out.println(s.closestValueBST(root,target));
    Solution1 s1= new Solution1();
    System.out.println(s1.closestValueBST(root,target));
    Solution2 s2= new Solution2();
    System.out.println(s2.closestValueBST(root,target));
  }
}