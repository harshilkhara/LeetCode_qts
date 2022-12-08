// Approach 1- Inorder Traversal and adding only leaf nodes 
class Solution { // TC O(n) SC O(n)
    List<Integer> list1= new ArrayList<>();
    List<Integer> list2= new ArrayList<>();

    public void inorder(TreeNode root, List<Integer> list){
        if(root==null) return;
        inorder(root.left,list);
        if(root.left==null & root.right==null){
            list.add(root.val);
        }
        inorder(root.right,list);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        inorder(root1,list1);
        inorder(root2,list2);
        return list1.equals(list2);

        
    }
}
