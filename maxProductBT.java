import java.util.*;
// Approach 1- DFS 
class Solution{
    public List<Integer> allSums = new ArrayList<>();

    public int maxProduct(Node root) {
        // long is a 64-bit integer.
        long totalSum = treeSum(root);
        long best = 0;
        for (long sum : allSums) {
            best = Math.max(best, sum * (totalSum - sum));
        }
        // We have to cast back to an int to match return value.
        return (int)(best % 1000000007);

    }

    public int treeSum(Node subroot) {
        if (subroot == null) return 0;
        int leftSum = treeSum(subroot.left);
        int rightSum = treeSum(subroot.right);
        int totalSum = leftSum + rightSum + subroot.val;
        allSums.add(totalSum);
        return totalSum;
    }
}

class maxProductBT{
    public static void main(String[] args) {
        BinaryTree bt= new BinaryTree();
        bt.root= new Node(1);
        bt.root.left=new Node(2);
        bt.root.right= new Node(3);
        bt.root.left.left=new Node(4);
        bt.root.left.right=new Node(5);
        bt.root.right.left=new Node(6);
        Solution s= new Solution();
        System.out.println(s.maxProduct(bt.root));
    }
}