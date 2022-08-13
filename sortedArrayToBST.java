// Approach 1- Picking left middle element from array as root 
class Solution { // TC O(N) SC O(log n)
    int[] nums;

    public Node helper(int left, int right) {
        if (left > right) return null;

        // always choose left middle node as a root
        int p = (left + right) / 2;

        // preorder traversal: node -> left -> right
        Node root = new Node(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }

    public Node sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }
}

class sortedArrayToBST{
    public static void main(String[] args) {
        int [] nums= {-10,-3,0,5,9};
        BST2 bst2= new BST2(); 
        Solution s =new Solution(); 
        Node root = s.sortedArrayToBST(nums); 
        bst2.preorder(root);
        bst2.inorder(root);

    }
}