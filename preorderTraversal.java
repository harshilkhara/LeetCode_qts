// Approach 1- Recursive DFS
class Solution{ // TC O(n) SC O(n)
    List<Integer> answer= new ArrayList<>();
    public void preorder(TreeNode root) {
        if(root==null) return;
        answer.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    
    }
    
     public List<Integer> preorderTraversal(TreeNode root) {
         preorder(root);
         return answer;
     }
} 

// Approach 2- Iterative DFS [using explicit call stack]
// NOTE- Push right node first and then left node to pop left node first 
class Solution1{ // TC O(n) SC O(n)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer= new ArrayList<>();
        Stack<TreeNode> stack= new Stack<>();
        if(root==null) return answer;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode currNode=stack.pop();
            answer.add(currNode.val);
            if(currNode.right!=null){
                stack.push(currNode.right);
            }
            if(currNode.left!=null){
                stack.push(currNode.left);
            }
        }
        return answer;
    }
}