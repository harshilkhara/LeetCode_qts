import java.util.*;
class Solution{
	public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

  public static int[] findTwoSwapped(List<Integer> nums) {
    int n = nums.size();
    int x = -1, y = -1;
    boolean swapped_first_occurrence = false;
    for(int i = 0; i < n - 1; ++i) {
      if (nums.get(i + 1) < nums.get(i)) {
        y = nums.get(i + 1);
        if (!swapped_first_occurrence) {
            // first swap occurrence
            x = nums.get(i);
            swapped_first_occurrence = true;
        } else {
            // second swap occurrence
            break;
        }
      }
    }
    return new int[]{x, y};
  }

  public static void recover(Node r, int count, int x, int y) {
    if (r != null) {
      if (r.val == x || r.val == y) {
        r.val = r.val == x ? y : x;
        if (--count == 0) return;
      }
      recover(r.left, count, x, y);
      recover(r.right, count, x, y);
    }
  }

  public void recoverTree(Node root) {
    List<Integer> nums = new ArrayList();
    inorder(root);
    int[] swapped = findTwoSwapped(nums);
    recover(root, 2, swapped[0], swapped[1]);
  }
}

class recoverBST{
	public static void main(String[] args) {
		int [] keys={1,3,2};
		BST2 bst2= new BST2();
		Node root= bst2.constructBST(keys);

		Solution s= new Solution(); 

		s.recoverTree(root);
		//s.inorder(root);

	}

}