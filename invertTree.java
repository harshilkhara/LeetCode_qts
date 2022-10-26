import java.util.*;


class Node{
    int val;
    Node left;
    Node right;

    Node(int x){
        val=x;
    }
}

class BinaryTree{
    Node root;
}

// Approach 1- BFS (Iterative) [using queue]
class Solution { // TC O(n)  SC O(n)
    public Node invertTree(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
}

// Approach 2- DFS (Recursive) [using call-stack]
class Solution1{ // TC O(n)  SC O(n)
    public Node invertTree(Node root){
        if(root==null)
            return root;
        Node left= invertTree(root.left);
        Node right= invertTree(root.right);
        root.left=right;
        root.right=left;

        return root;
    }

    public void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.val+ " ");
        inorder(root.right);
    }
}


class invertTree{
    public static void main(String[] args) {
        BinaryTree bt= new BinaryTree();
        bt.root= new Node(4);
        bt.root.left= new Node(2);
        bt.root.left.left=new Node(1);
        bt.root.left.right=new Node(3);
        bt.root.right=new Node(7);
        bt.root.right.left= new Node(6);
        bt.root.right.right=new Node(9);

        Solution1 s1= new Solution1();
        Node result= s1.invertTree(bt.root);
        s1.inorder(result);
    }
}