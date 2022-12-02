import java.util.*;
// Approach 1- Recursion 
class Solution {
    public Node mergeTrees(Node root1, Node root2) {
        if (root1==null)
            return root2;
        if(root2==null)
            return root1;
        root1.val+=root2.val;
        root1.left=mergeTrees(root1.left,root2.left);
        root1.right=mergeTrees(root1.right,root2.right);
        return root1;
    }
}

// Approach 2- Iterative [using explicit stack]
class Solution1{
    public Node mergeTrees(Node t1, Node t2) {
        if (t1 == null)
            return t2;
        Stack < Node[] > stack = new Stack <> ();
        stack.push(new Node[] {t1, t2});
        while (!stack.isEmpty()) {
            Node[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new Node[] {t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new Node[] {t[0].right, t[1].right});
            }
        }
        return t1;
    }
}

class mergeTrees{
    public static void main(String[] args) {
        BinaryTree bt= new BinaryTree();
        bt.root1=new Node(1);
        bt.root1.left=new Node(3);
        bt.root1.right=new Node(2);
        bt.root1.left.left= new Node(5);

        bt.root2=new Node(2);
        bt.root2.left=new Node(1);
        bt.root2.right=new Node(3);
        bt.root2.left.right=new Node(4);
        bt.root2.right.right=new Node(7);

        Solution s= new Solution();
        Node result= bt.mergeTrees(bt.root1,bt.root2);
        bt.inorder(result);

        Solution1 s1= new Solution1();
        Node result1= bt.mergeTrees(bt.root1,bt.root2);
        bt.inorder(result1);

    }
}

