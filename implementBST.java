import java.util.*;
class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class BST{

  TreeNode root;

  // Iterative Approach TC O(log n) SC O(1)
  public void insertIntoBST(int key){
    TreeNode node=new TreeNode(key);
    if(root==null) {
        root = node;
        return;
    }
    TreeNode prev=null;
    TreeNode temp=root;
    while (temp!=null){
        if(temp.val>key){
            prev=temp;
            temp=temp.left;
        }
        else if (temp.val<key){
            prev=temp;
            temp=temp.right;
        }
    }
    if(prev.val>key)
        prev.left=node;
    else prev.right=node;
  }

  public void inorder(){
    TreeNode temp=root;
    Stack<TreeNode> stack=new Stack<>();
    while (temp!=null||!stack.isEmpty()){
        if(temp!=null){
            stack.add(temp);
            temp=temp.left;
        }
        else {
            temp=stack.pop();
            System.out.print(temp.val+" ");
            temp=temp.right;
        }
      }
  }
}

class implementBST{
  public static void main(String [] args){
    BST bst= new BST();
    bst.insertIntoBST(8);
    bst.insertIntoBST(3);
    bst.insertIntoBST(7);
    bst.insertIntoBST(5);
    bst.insertIntoBST(1);
    bst.inorder();
  }
}