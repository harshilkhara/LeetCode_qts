import java.util.*;
// Approach 1- Naive Solution - converting it into list and returning the next element
class Solution { // TC O(n) SC O(n)
    List<Integer> list= new ArrayList<>();
    
    public void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public Node inorderSuccessor(Node root, Node p) {
        inorder(root);
        for(int i=0; i<list.size(); i++){
            if (p.val==list.get(i)){
                return (list.size()>i+1) ? new Node(list.get(i+1)): null;
            }
        }
        return null;
    }
}

// Approach 2- Using BST properties
class Solution1{ // TC O(log n) SC O(1)
    public Node inorderSuccessor(Node root, Node p){
        Node successor=null;
        while(root!=null){
            if(p.val>=root.val){
                root=root.right;
            } else {
                successor=root;
                root=root.left;
            }
        }
        return successor;
    }
}

class inorderSuccessor{
    public static void main(String[] args) {
        BST2 bst2=new BST2();
        int[] keys={2,1,3};
        Node root=bst2.constructBST(keys);
        Solution s= new Solution();
        Solution1 s1= new Solution1();
        Node p=new Node(1);
        Node result=s.inorderSuccessor(root,p);
        System.out.println(result.val);
        Node result1=s1.inorderSuccessor(root,p);
        System.out.println(result1.val);

    }
}