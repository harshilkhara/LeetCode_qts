import java.util.*;
// Approach 1- Recursive (DFS) [using implicit call stack]
class Solution{ // TC O(n) SC O(n)
    public boolean isSymmetric(Node root) {
    return isMirror(root, root);
}

public boolean isMirror(Node t1, Node t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return (t1.val == t2.val)
        && isMirror(t1.right, t2.left)
        && isMirror(t1.left, t2.right);
    }
}

// Approach 2- Iterative (BFS) [using queue]
class Solution1{
    public boolean isSymmetric(Node root) {
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            Node t1=queue.poll();
            Node t2=queue.poll();
            if(t1==null && t2==null) continue;
            if(t1==null || t2==null) return false;
            if(t1.val!=t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }
}

class isSymmetric{
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root=new Node(1);
        bt.root.left=new Node(2);
        bt.root.right=new Node(2);
        bt.root.left.left=new Node(3);
        bt.root.left.right=new Node(4);
        bt.root.right.left=new Node(4);
        bt.root.right.right=new Node(3);
        Solution s= new Solution();
        System.out.println(s.isSymmetric(bt.root));
        Solution1 s1= new Solution1();
        System.out.println(s1.isSymmetric(bt.root));
    }
}