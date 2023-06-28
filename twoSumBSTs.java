import java.util.*;
// Approach 1- Inorder and HashSet
class Solution { // TC O(n) SC O(n)
    List<Integer> list= new ArrayList<>();
    int target;
    public void inorder(Node root){
        if (root==null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    
    public boolean twoSumBSTs(Node root1, Node root2, int target) {
        this.target=target;
        inorder(root1);
        Set<Integer> set= new HashSet<>(list);
        list.clear();
        inorder(root2);
        for(int i=0; i<list.size(); i++){
            int complement=target-list.get(i);
            if(set.contains(complement)){
                return true;
            }
            set.add(list.get(i));
        }
        return false;
    }
}

class twoSumBSTs{
    public static void main(String[] args) {
        BST2 bst2= new BST2();
        int[] keys={2,1,4};
        int[] keys1={1,0,3};
        Node root1=bst2.constructBST(keys);
        Node root2=bst2.constructBST(keys1);
        int target=5;
        Solution s= new Solution();
        System.out.println(s.twoSumBSTs(root1,root2,target));
    }
}