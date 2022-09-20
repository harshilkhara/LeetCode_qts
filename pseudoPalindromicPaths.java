import java.util.*;

class Pair{
    Node node;
    Integer path;
    Pair(Node root, Integer path){
        node=root;
        this.path=path;
    }
}

// Approach 1- DFS (Recursive) [using call-stack]
class Solution { // TC O(N) SC O(N)
    int ans=0;
    public int pseudoPalindromicPaths (Node root) {
        Set<Integer> nodeSet= new HashSet<>();
        preorder(root,nodeSet);
        return ans;
    }
    
    public void preorder(Node curr, Set<Integer> nodeSet){
        if (curr==null) return; 
        
        if (nodeSet.contains(curr.val)){
            nodeSet.remove(curr.val);
        } else{
            nodeSet.add(curr.val);
        }
        if(curr.left==null && curr.right==null){
            if(nodeSet.size()<=1)
                ans++;
        }
        preorder(curr.left,new HashSet<>(nodeSet));
        preorder(curr.right, new HashSet<>(nodeSet));
    }
}

// Approach 2- Iterative Preorder Traversal (Preorder is basically DFS)
class Solution1{ // TC O(N) SC O(N)
    public int pseudoPalindromicPaths (Node root) {
        int count = 0, path = 0;
        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(root, 0));
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            Node node = p.node;
            path = p.path;

            if (node != null) {
                // compute occurences of each digit 
                // in the corresponding register
                path = path ^ (1 << node.val);
                // if it's a leaf check if the path is pseudo-palindromic
                if (node.left == null && node.right == null) {
                    // check if at most one digit has an odd frequency
                    if ((path & (path - 1)) == 0) {
                        ++count;
                    }
                } else {
                    stack.push(new Pair(node.right, path));
                    stack.push(new Pair(node.left, path));
                }
            }
        }
        return count;
    }
}

// Approach 3- Recursive Preorder Traversal [using call-stack]
class Solution2{ // TC O(N) SC O(N)
    int count = 0;
    public void preorder(Node node, int path) {
        if (node != null) {
            // compute occurences of each digit 
            // in the corresponding register
            path = path ^ (1 << node.val);
            // if it's a leaf check if the path is pseudo-palindromic
            if (node.left == null && node.right == null) {
                // check if at most one digit has an odd frequency
                if ((path & (path - 1)) == 0) {
                    ++count;
                }
            }
            preorder(node.left, path);
            preorder(node.right, path) ;
        }
    }

    public int pseudoPalindromicPaths (Node root) {
        preorder(root, 0);
        return count;
    }
}

class pseudoPalindromicPaths{
    public static void main(String[] args) {
        BinaryTree bt= new BinaryTree();
        bt.root=new Node(2);
        bt.root.left=new Node(3);
        bt.root.right= new Node(1);
        bt.root.left.left=new Node(3);
        bt.root.left.right=new Node(1);
        bt.root.right.right=new Node(1);
        Solution s= new Solution();
        System.out.println(s.pseudoPalindromicPaths(bt.root));
        Solution1 s1= new Solution1();
        System.out.println(s1.pseudoPalindromicPaths(bt.root));
        Solution2 s2= new Solution2();
        System.out.println(s2.pseudoPalindromicPaths(bt.root));
    }
}