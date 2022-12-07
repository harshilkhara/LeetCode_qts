import java.util.*;
// Approach 1- Naive Solution- Inorder Traversal
class Solution { // TC O(n) SC O(n)
    List<Integer> list= new ArrayList<>();
    public void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);

    }
    public int rangeSumBST(Node root, int low, int high) {
        inorder(root);
        int sum=0;
        for (int i=0; i<list.size(); i++){
            if (low<=list.get(i) && list.get(i)<=high){
                sum+=list.get(i);
            }
        }
        return sum;
    }
}

// Approach 2- Recursive [using implicit call-stack]
class Solution1{ // TC O(n) SC O(n)
    int sum=0;
    public void dfs (Node root,int low, int high){
        if(root!=null){
            if(low<=root.val && root.val<=high){
                sum+=root.val;
            }
            if (low<root.val){
                dfs(root.left,low,high);
            }
            if(root.val<high){
                dfs(root.right,low,high);
            }
        }
    }

    public int rangeSumBST(Node root,int low, int high){
        dfs(root,low,high);
        return sum;
    }
}

// Approach 3- Iterative [using explicit call-stack]
class Solution2{ // TC O(n) SC O(n)
    public int rangeSumBST(Node root, int low, int high){
        if(root==null) return 0;
        Stack<Node> stack =new Stack<>();
        stack.push(root);
        int sum=0;
        while(!stack.isEmpty()){
            Node currNode= stack.pop();
            if(currNode!=null){
                if(low<=currNode.val && currNode.val<=high){
                sum+=currNode.val;
                }
                if (currNode.val<high){
                    stack.push(currNode.right);
                }
                if(low<currNode.val){
                    stack.push(currNode.left);
                }
            }
        }
        return sum;
    }
}


class rangeSumBST{
    public static void main(String[] args) {
        int[] keys= {10,5,15,3,7,18};
        BST2 bst2 = new BST2();
        Node root=bst2.constructBST(keys);
        int low=7, high=15;
        Solution s= new Solution();
        System.out.println(s.rangeSumBST(root,low,high));
        Solution1 s1= new Solution1();
        System.out.println(s1.rangeSumBST(root,low,high));
        Solution2 s2= new Solution2();
        System.out.println(s2.rangeSumBST(root,low,high));

    }
}